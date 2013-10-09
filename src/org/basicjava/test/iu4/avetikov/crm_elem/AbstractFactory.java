package org.basicjava.test.iu4.avetikov.crm_elem;

import org.basicjava.test.iu4.avetikov.Factory;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import java.sql.*;

/**
 * User: Mr. Avetik
 * Date: 28.09.13
 * Time: 15:27
 */
public abstract class AbstractFactory implements CrmElemFactory {

    public abstract class AbstractCrmElem implements CrmElemInt{
        protected Connection connection;
        protected Statement statement;
        protected String query;
        protected Long id;

        public AbstractCrmElem(Long id){
            this.id = id;
        }
        public Long getId(){
            return id;
        }
        public void getRow() throws SQLException {
            try {
                Class.forName("org.hsqldb.jdbcDriver");
            } catch (ClassNotFoundException e) {
                System.err.println("Нe удалось загрузить драйвер ДБ.");
                e.printStackTrace();
        	    System.exit(1);
            }

            try {
           	    connection = DriverManager.getConnection("jdbc:hsqldb:file:db/dbname", "SA", "");
            } catch (SQLException e) {
           	    System.err.println("Нe удалось cоздать соединение.");
           	    e.printStackTrace();
           	    System.exit(1);
            }

            try {
               	this.statement = this.connection.createStatement();
            }catch (SQLException e){
                    statement.close();
                    connection.close();
            }
        }

        public void getRow(Timestamp date) throws SQLException {
            getRow();
        }

        public TreeModel getTree(Timestamp date) throws SQLException {
            if (!this.statement.isClosed()){ this.statement.close(); }
            if (!this.connection.isClosed()){ this.connection.close(); }
            ResultSet resultSetC;
            ResultSet resultSetPA;
            ResultSet resultSetTD;
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Дамп БД по Дате");

            this.query = "SELECT * FROM Contract c WHERE c.dateFrom < '"+date+"' AND COALESCE(c.dateTO, CURRENT_DATE) > '"+date+"';";
            getRow();
            resultSetC = this.statement.executeQuery(this.query);

            while(resultSetC.next()){
                CrmElemInt contract = Factory.getObject(resultSetC.getLong("contractID"),ContractFactory.TYPE);
                contract.getRow(date);
                DefaultMutableTreeNode contr = new DefaultMutableTreeNode(contract);

                this.query = "SELECT pa.personalAccountID, pa.dateFrom, pa.dateTo, pa.personalAccountNumber, pa.calculationMathodID " +
                             "  FROM PersonalAccount pa " +
                             "  JOIN ContractPA cpa ON cpa.personalAccountID = pa.personalAccountID" +
                             "                      AND cpa.contractID = "+contract.getId()+" " +
                             "                      AND cpa.dateFrom < '"+date+"' " +
                             "                      AND COALESCE(cpa.dateTo, CURRENT_DATE) > '"+date+"' " +
                             " WHERE pa.dateFrom < '"+date+ "' " +
                             "   AND COALESCE(pa.dateTo, CURRENT_DATE) > '"+date+"';";
                resultSetPA = this.statement.executeQuery(this.query);

                while(resultSetPA.next()){
                    CrmElemInt personalAccount = Factory.getObject(resultSetPA.getLong("personalAccountID"),PersonalAccountFactory.TYPE);
                    personalAccount.getRow(date);
                    DefaultMutableTreeNode persAcc = new DefaultMutableTreeNode(personalAccount);

                    this.query = "SELECT td.* " +
                                 "  FROM TerminalDevice td" +
                                 "  JOIN PersonalAccountTD patd ON patd.terminalDeviceID = td.terminalDeviceID" +
                                 "                              AND patd.personalAccountID = "+personalAccount.getId()+" " +
                                 "                              AND patd.dateFrom < '"+date+"' " +
                                 "                              AND COALESCE(patd.dateTo, CURRENT_DATE) > '"+date+"' " +
                                 " WHERE td.dateFrom < '"+date+"' " +
                                 "   AND COALESCE(td.dateTo, CURRENT_DATE) > '"+date+"';";
                    resultSetTD = this.statement.executeQuery(this.query);

                    while (resultSetTD.next()){
                        CrmElemInt terminalDevice = Factory.getObject(resultSetTD.getLong("terminalDeviceID"),TerminalDeviceFactory.TYPE);
                        terminalDevice.getRow(date);
                        persAcc.add(new DefaultMutableTreeNode(terminalDevice));
                    }

                    contr.add(persAcc);
                }

                root.add(contr);
            }

            return new DefaultTreeModel(root);// new DefaultTreeModel();
        }
    }
}
