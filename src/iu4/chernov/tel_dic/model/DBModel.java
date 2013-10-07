package iu4.chernov.tel_dic.model;

import iu4.chernov.tel_dic.factory.Factory;
import iu4.chernov.tel_dic.factory.elem.ContractFactory;
import iu4.chernov.tel_dic.factory.elem.CrmElemFactory;
import iu4.chernov.tel_dic.factory.elem.PersonalAccountFactory;
import iu4.chernov.tel_dic.factory.elem.TerminalDeviceFactory;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import java.sql.*;
import java.util.HashMap;

/**
 * User: Maxim
 * Date: 07.10.13
 * Time: 17:33
 */
public class DBModel {
    public static final String PROP_DB_PATH = "PROP_DB_PATH";
    public static final String PROP_DB_NAME = "PROP_DB_NAME";
    public static final String PROP_DB_USER = "PROP_DB_USER";
    public static final String PROP_DB_PASS = "PROP_DB_PASS";

    Connection connection;

    public DBModel(String dbPath, String dbName, String dbUser, String dbPass){
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Нe удалось загрузить драйвер ДБ.");
            e.printStackTrace();
            System.exit(1);
        }

        try {
            connection = DriverManager.getConnection("jdbc:hsqldb:file:"+ dbPath +"/"+ dbName+"", dbUser, dbPass);
        } catch (SQLException e) {
            System.err.println("Нe удалось cоздать соединение.");
            e.printStackTrace();
            System.exit(1);
        }

    }

    public HashMap<Long,TerminalDeviceFactory.TerminalDevice> getTerminalDevices(Timestamp date, Long personalAccountId){
        HashMap<Long,TerminalDeviceFactory.TerminalDevice> terminalDevices =
                new HashMap<Long, TerminalDeviceFactory.TerminalDevice>();

        String query;

        query = "SELECT d.terminalDeviceId, d.dateFrom, d.dateTo, r. personalAccountId " +
                "FROM TerminalDevice d " +
                "  JOIN PersonalAccountTD r ON d.terminalDeviceId = r.terminalDeviceId " +
                "WHERE dateFrom <= '" + date + "'" +
                " AND dateTo > '" + date + "'";
        if (personalAccountId != null) query = query + " AND r.personalAccountId = " + personalAccountId;
        ResultSet res = execute(query);
        try {
            while (res.next()){
                Long id = res.getLong("terminalDeviceId");
                Timestamp dateFrom = res.getTimestamp("dateFrom");
                Timestamp dateTo = res.getTimestamp("dateTo");
                personalAccountId = res.getLong("personalAccountId");

                TerminalDeviceFactory.TerminalDevice elem =
                        (TerminalDeviceFactory.TerminalDevice)Factory.genCrmElem(id,TerminalDeviceFactory.TYPE,date);
                elem.setDateFrom(dateFrom);
                elem.setDateTo(dateTo);

                elem.setPersonalAccount(personalAccountId);

                terminalDevices.put(id,elem);

            }
            return terminalDevices;
        } catch (SQLException ex){
            System.out.println("Ошибка извлечения данных!");
            return null;
        }
    }

    public HashMap<Long,PersonalAccountFactory.PersonalAccount> getPersonalAccounts(Timestamp date, Long contractId){
        HashMap<Long,PersonalAccountFactory.PersonalAccount> personalAccounts =
                new HashMap<Long, PersonalAccountFactory.PersonalAccount>();

        String query;

        query = "SELECT a.personalAccountId, a.dateFrom, a.dateTo, r.contractID " +
                "FROM PersonalAccount a " +
                "  JOIN ContractPA r ON a.personalAccountId = r.personalAccountId " +
                "WHERE dateFrom <= '" + date + "'" +
                " AND dateTo > '" + date + "'";
        if (contractId != null) query = query + " AND r.contractId = " + contractId;
        ResultSet res = execute(query);
        try {
            while (res.next()){
                Long id = res.getLong("personalAccountId");
                Timestamp dateFrom = res.getTimestamp("dateFrom");
                Timestamp dateTo = res.getTimestamp("dateTo");
                contractId = res.getLong("contractID");

                PersonalAccountFactory.PersonalAccount elem =
                        (PersonalAccountFactory.PersonalAccount)Factory.genCrmElem(id,PersonalAccountFactory.TYPE,date);
                elem.setDateFrom(dateFrom);
                elem.setDateTo(dateTo);
                elem.setContractId(contractId);

                personalAccounts.put(id,elem);

            }
            return personalAccounts;
        } catch (SQLException ex){
            System.out.println("Ошибка извлечения данных!");
            return null;
        }
    }

    public HashMap<Long,ContractFactory.Contract> getContracts(Timestamp date){
        HashMap<Long,ContractFactory.Contract> contracts = new HashMap<Long, ContractFactory.Contract>();

        String query = "SELECT contractId, contractNumber, dateFrom, dateTo " +
                "FROM Contract " +
                "WHERE dateFrom <= '" + date + "'" +
                " AND dateTo > '" + date + "'";

        ResultSet res = execute(query);

        try{
            while (res.next()){
                Long contractId = res.getLong("contractId");
                Long contractNumber = res.getLong("contractNumber");
                Timestamp dateFrom = res.getTimestamp("dateFrom");
                Timestamp dateTo = res.getTimestamp("dateTo");

                ContractFactory.Contract contract = (ContractFactory.Contract)Factory.genCrmElem(contractId,
                        ContractFactory.TYPE,date);

                contract.setNumber(contractNumber);
                contract.setDateFrom(dateFrom);
                contract.setDateTo(dateTo);

                contracts.put(contractId,contract);
            }
            return contracts;
        } catch (SQLException ex){
            System.out.println("Ошибка извлечения данных!");
            return null;
        }
    }

    public TreeModel getTree(Timestamp date){
        HashMap<Long,ContractFactory.Contract> contracts = getContracts(date);
        HashMap<Long,PersonalAccountFactory.PersonalAccount> accounts = getPersonalAccounts(date,null);
        HashMap<Long,TerminalDeviceFactory.TerminalDevice> devices = getTerminalDevices(date,null);

        HashMap<Long,DefaultMutableTreeNode> contractNodes = new HashMap<Long, DefaultMutableTreeNode>();
        HashMap<Long,DefaultMutableTreeNode> accountNodes = new HashMap<Long, DefaultMutableTreeNode>();
        HashMap<Long,DefaultMutableTreeNode> deviceNodes = new HashMap<Long, DefaultMutableTreeNode>();

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Срез за дату " + date);

        for (ContractFactory.Contract contract: contracts.values()){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(contract);
            root.add(node);
            contractNodes.put(contract.getId(),node);
        }

        for (PersonalAccountFactory.PersonalAccount account: accounts.values()){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(account);
            DefaultMutableTreeNode contractNode = contractNodes.get(account.getContractId());
            if (contractNode != null) contractNode.add(node);
        }

        for (TerminalDeviceFactory.TerminalDevice device: devices.values()){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(device);
            DefaultMutableTreeNode contractNode = accountNodes.get(device.getPersonalAccount());
            if (contractNode != null) contractNode.add(node);
        }

        DefaultTreeModel model = new DefaultTreeModel(root);
        return model;
    }

    private ResultSet execute(String query){
        try{
            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery(query);
            return res;
        }
        catch (SQLException ex){
            System.out.println("Ошибка считывания с БД ");
            ex.printStackTrace();
            return null;
        }
    }
}
