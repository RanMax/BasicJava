package iu4.avetikov;

import iu4.avetikov.crm_elem.CrmElemFactory;
import iu4.avetikov.crm_elem.PersonalAccountFactory;
import iu4.avetikov.crm_elem.TerminalDeviceFactory;
import iu4.avetikov.crm_elem.ContractFactory;

import java.sql.*;

/**
 * Created by IntelliJ IDEA.
 * User: Mr. Avetik
 * Date: 21.09.13
 * Time: 0:02
 * To change this template use File | Settings | File Templates.
 */

public class DBConnection {
    public static void main(String[] args) {

        /*ArrayList<Table> TT = new ArrayList<Table>();

		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("Нe удалось загрузить драйвер ДБ.");
			e.printStackTrace();
			System.exit(1);
		}

		Connection con = null;
		try {
			con = DriverManager.getConnection(
                    "jdbc:hsqldb:file:dbpath/dbname", "SA", "");
		} catch (SQLException e) {
			System.err.println("Нe удалось cоздать соединение.");
			e.printStackTrace();
			System.exit(1);
		}

		try {
			Statement stat = con.createStatement();
			String query = null;
                           //"CONNECT USER Avet PASSWORD '12345';"+
			               //"CREATE TABLE TerminalDevice (terminalDeviceID integer , dateFrom date, dateTo date, terminalDeviceNumber integer, tariffPlanID integer)";
                           //"DROP USER Avet";
                           //"DROP TABLE TestTable";

			try {
				stat.execute(query);
			} catch (SQLException e) {
                System.err.println("Не получилось...");
                e.printStackTrace();
                System.exit(1);
            }


			query = "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (19115169, convert(date,'24-08-2006 17:10:47'), to_date('30/09/2006 20:50:41'), 7776, '79197748564');";
			stat.executeUpdate(query);


			query = "SELECT id, gorod, region FROM TestTable";
			ResultSet rs = stat.executeQuery(query);

            query = "COMMIT";
            if (stat.execute(query)) {
                System.out.println("COMMIT!");
            }else { System.out.println("COMMIT faild..."); }

			while (rs.next()) {
                TT.add(new Table(rs.getInt("ID"),rs.getString("gorod"),rs.getString("region")));
			}

            for(int i=0;i<TT.size();i++){
                System.out.println(TT.get(i).toString());
            }

            query = "SHUTDOWN";
            stat.execute(query);

            //rs.close();
			stat.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}*/

        /*TableFactory tableFactory = new TableFactory();
        Table table = new Table(tableFactory);
        table.getTable("TerminalDevice");
        table.getTable("PersonalAccountTD");
        table.getTable("PersonalAccount");
        table.getTable("ContractPersonalAccount");
        table.getTable("Contract");
        table.getTable("TariffPlan");
        table.getTable("MarketingCategory");
        table.getTable("CalculationMethod");*/

        CrmElemFactory.CrmElemInt crmElemInt1 = Factory.getObject(1,ContractFactory.TYPE);
        CrmElemFactory.CrmElemInt crmElemInt2 = Factory.getObject(2,PersonalAccountFactory.TYPE);
        CrmElemFactory.CrmElemInt crmElemInt3 = Factory.getObject(3,TerminalDeviceFactory.TYPE);
        try{
            crmElemInt1.getRow();
            crmElemInt2.getRow();
            crmElemInt3.getRow();
        } catch (SQLException e){
            System.err.println("Method getRow() faild...");
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Contract: " + crmElemInt1);
        System.out.println("PersonalAccount: " + crmElemInt2);
        System.out.println("TerminalDevice: " + crmElemInt3);
	}
}