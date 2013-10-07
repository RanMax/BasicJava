package iu4.avetikov;

import iu4.avetikov.crm_elem.*;

import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import java.util.Enumeration;

/**
 * Created by IntelliJ IDEA.
 * User: Mr. Avetik
 * Date: 21.09.13
 * Time: 0:02
 * To change this template use File | Settings | File Templates.
 */


public class DBConnection {
    public static void main(String[] args) {

		/*try {
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
//			String query = null;
//			               "CREATE TABLE TerminalDevice (terminalDeviceID bigint , dateFrom datetime, dateTo datetime, tariffPlanID bigint, msisdn varchar(15));\n" +
//                           "CREATE TABLE PersonalAccountTD (personalAccountTDID bigint , dateFrom datetime, dateTo datetime, personalAccountID bigint, terminalDeviceID bigint);\n" +
//                           "CREATE TABLE PersonalAccount (personalAccountID bigint , dateFrom datetime, dateTo datetime, personalAccountNumber bigint, calculationMathodID bigint);\n" +
//                           "CREATE TABLE ContractPA (contractPAID bigint , dateFrom datetime, dateTo datetime, contractID bigint, personalAccountID bigint);\n" +
//                           "CREATE TABLE Contract (contractID bigint , dateFrom datetime, dateTo datetime, contractNumber bigint, marketingCategoryID bigint);\n" +
//                           "CREATE TABLE TeriffPlan (tariffPlanID bigint , tariffPlanName varchar(100));\n" +
//                           "CREATE TABLE CalculationMethod (calculationMethodID bigint ,calculationMethodName varchar(100));\n" +
//                           "CREATE TABLE MarketingCategory (marketingCategoryID bigint, marketingCategoryName varchar(100));";
//                           "DROP TABLE TerminalDevice;\n" +
//                           "DROP TABLE PersonalAccountTD;\n" +
//                           "DROP TABLE PersonalAccount;\n" +
//                           "DROP TABLE ContractPA;\n" +
//                           "DROP TABLE Contract;\n" +
//                           "DROP TABLE TeriffPlan;\n" +
//                           "DROP TABLE CalculationMethod;\n" +
//                           "DROP TABLE MarketingCategory;";

			try {
				stat.execute(query);
			} catch (SQLException e) {
                System.err.println("Не получилось...");
                e.printStackTrace();
                System.exit(1);
            }

			query = "insert into Contract(contractID , dateFrom , dateTo , contractNumber , marketingCategoryID)\n" +
                    "values(19991478, '2013-05-22 09:23:12', NULL, 177333961019, 1180);\n" +
                    "insert into Contract(contractID , dateFrom , dateTo , contractNumber , marketingCategoryID)\n" +
                    "values(20345550, '2011-09-28 17:08:13', NULL, 177334134254, 1180);\n" +
                    "insert into Contract(contractID , dateFrom , dateTo , contractNumber , marketingCategoryID)\n" +
                    "values(65486911, '2013-04-15 15:33:51', NULL, 177360931679, 1906);\n" +
                    "insert into ContractPA(contractPAID , dateFrom , dateTo , contractID , personalAccountID)\n" +
                    "values(19067481, '2006-08-24 17:10:47', NULL, 19991478, 19338396);\n" +
                    "insert into ContractPA(contractPAID , dateFrom , dateTo , contractID , personalAccountID)\n" +
                    "values(19392017, '2006-09-19 08:34:05', NULL, 20345550, 19664280);\n" +
                    "insert into ContractPA(contractPAID , dateFrom , dateTo , contractID , personalAccountID)\n" +
                    "values(68489329, '2011-08-29 15:36:03', NULL, 65486911, 67757437);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19338396, '2006-08-24 17:10:47', '2007-01-06 23:59:59', 277333525072, 1);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19338396, '2007-01-07 00:00:00', '2008-06-13 19:47:12', 277333525072, 1);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19338396, '2008-06-13 19:47:13', '2009-07-03 02:14:03', 277333525072, 1);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19338396, '2009-07-03 02:14:04', '2009-07-14 23:42:35', 277333525072, 3);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19338396, '2009-07-14 23:42:36', '2009-12-23 14:28:49', 277333525072, 3);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19338396, '2009-12-23 14:28:50', '2010-04-11 13:50:39', 277333525072, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19338396, '2010-04-11 13:50:40', '2010-08-07 06:49:42', 277333525072, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19338396, '2010-08-07 06:49:43', '2012-02-03 18:53:19', 277333525072, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19338396, '2012-02-03 18:53:20', '2012-05-08 19:37:10', 277333525072, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19338396, '2012-05-08 19:37:11', '2013-03-03 23:32:05', 277333525072, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19338396, '2013-03-03 23:32:06', NULL, 277333525072, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19664280, '2006-09-19 08:34:05', '2007-01-06 23:59:59', 277333700132, 1);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19664280, '2007-01-07 00:00:00', '2007-05-15 23:40:35', 277333700132, 1);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19664280, '2007-05-15 23:40:36', '2007-07-31 04:10:57', 277333700132, 1);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19664280, '2007-07-31 04:10:58', '2010-03-09 10:17:32', 277333700132, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19664280, '2010-03-09 10:17:33', '2010-03-23 14:24:41', 277333700132, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19664280, '2010-03-23 14:24:42', '2010-04-09 07:58:06', 277333700132, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19664280, '2010-04-09 07:58:07', '2010-08-06 19:24:43', 277333700132, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19664280, '2010-08-06 19:24:44', '2010-12-02 00:46:23', 277333700132, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19664280, '2010-12-02 00:46:24', '2011-02-02 12:57:28', 277333700132, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19664280, '2011-02-02 12:57:29', '2011-06-07 02:11:13', 277333700132, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19664280, '2011-06-07 02:11:14', '2011-09-11 13:26:37', 277333700132, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19664280, '2011-09-11 13:26:38', '2012-03-02 14:33:26', 277333700132, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19664280, '2012-03-02 14:33:27', '2012-06-06 20:37:34', 277333700132, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19664280, '2012-06-06 20:37:35', '2012-10-01 23:32:30', 277333700132, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19664280, '2012-10-01 23:32:31', '2013-01-03 19:21:02', 277333700132, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19664280, '2013-01-03 19:21:03', '2013-03-02 02:50:51', 277333700132, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19664280, '2013-03-02 02:50:52', '2013-06-02 22:03:22', 277333700132, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19664280, '2013-06-02 22:03:23', '2013-07-02 16:26:18', 277333700132, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19664280, '2013-07-02 16:26:19', '2013-10-02 00:07:29', 277333700132, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(19664280, '2013-10-02 00:07:30', NULL, 277333700132, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(67757437, '2011-08-29 15:36:03', '2013-04-15 15:33:50', 277362046950, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(67757437, '2013-04-15 15:33:51', '2013-04-15 15:35:27', 277362046950, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(67757437, '2013-04-15 15:35:28', '2013-04-19 15:09:11', 277362046950, 2);\n" +
                    "insert into PersonalAccount(personalAccountID , dateFrom , dateTo , personalAccountNumber , calculationMathodID)\n" +
                    "values(67757437, '2013-04-19 15:09:12', NULL, 277362046950, 2);\n" +
                    "insert into PersonalAccountTD(personalAccountTDID , dateFrom , dateTo , personalAccountID , terminalDeviceID)\n" +
                    "values(19061018, '2006-08-24 17:10:47', NULL, 19338396, 19115169);\n" +
                    "insert into PersonalAccountTD(personalAccountTDID , dateFrom , dateTo , personalAccountID , terminalDeviceID)\n" +
                    "values(19386613, '2006-09-19 08:34:05', NULL, 19664280, 19441439);\n" +
                    "insert into PersonalAccountTD(personalAccountTDID , dateFrom , dateTo , personalAccountID , terminalDeviceID)\n" +
                    "values(70738704, '2011-08-29 15:36:03', NULL, 67757437, 100571740);\n" +
                    "insert into TerminalDevice(terminalDeviceID , dateFrom , dateTo , tariffPlanID , msisdn)\n" +
                    "values(19115169, '2006-08-24 17:10:47', '2006-09-30 20:50:41', 7776, '79197748564');\n" +
                    "insert into TerminalDevice(terminalDeviceID , dateFrom , dateTo , tariffPlanID , msisdn)\n" +
                    "values(19115169, '2006-09-30 20:50:42', '2007-05-01 21:49:05', 7776, '79197748564');\n" +
                    "insert into TerminalDevice(terminalDeviceID , dateFrom , dateTo , tariffPlanID , msisdn)\n" +
                    "values(19115169, '2007-05-01 21:49:06', '2009-07-03 02:14:04', 8116, '79197748564');\n" +
                    "insert into TerminalDevice(terminalDeviceID , dateFrom , dateTo , tariffPlanID , msisdn)\n" +
                    "values(19115169, '2009-07-03 02:14:05', '2010-07-02 13:10:41', 10834, '79197748564');\n" +
                    "insert into TerminalDevice(terminalDeviceID , dateFrom , dateTo , tariffPlanID , msisdn)\n" +
                    "values(19115169, '2010-07-02 13:10:42', '2013-06-10 09:12:14', 11245, '79197748564');\n" +
                    "insert into TerminalDevice(terminalDeviceID , dateFrom , dateTo , tariffPlanID , msisdn)\n" +
                    "values(19115169, '2013-06-10 09:12:15', NULL, 15634, '79197748564');\n" +
                    "insert into TerminalDevice(terminalDeviceID , dateFrom , dateTo , tariffPlanID , msisdn)\n" +
                    "values(19441439, '2006-09-19 08:34:05', '2010-03-23 14:24:42', 11, '79165673658');\n" +
                    "insert into TerminalDevice(terminalDeviceID , dateFrom , dateTo , tariffPlanID , msisdn)\n" +
                    "values(19441439, '2010-03-23 14:24:43', '2013-06-10 09:12:13', 11245, '79165673658');\n" +
                    "insert into TerminalDevice(terminalDeviceID , dateFrom , dateTo , tariffPlanID , msisdn)\n" +
                    "values(19441439, '2013-06-10 09:12:14', NULL, 15634, '79165673658');\n" +
                    "insert into TerminalDevice(terminalDeviceID , dateFrom , dateTo , tariffPlanID , msisdn)\n" +
                    "values(100571740, '2011-08-29 15:36:03', '2012-10-15 15:35:04', 10839, '79166145440');\n" +
                    "insert into TerminalDevice(terminalDeviceID , dateFrom , dateTo , tariffPlanID , msisdn)\n" +
                    "values(100571740, '2012-10-15 15:35:05', '2013-04-15 15:33:50', 16414, '79166145440');\n" +
                    "insert into TerminalDevice(terminalDeviceID , dateFrom , dateTo , tariffPlanID , msisdn)\n" +
                    "values(100571740, '2013-04-15 15:33:51', '2013-04-17 14:21:19', 16414, '79166145440');\n" +
                    "insert into TerminalDevice(terminalDeviceID , dateFrom , dateTo , tariffPlanID , msisdn)\n" +
                    "values(100571740, '2013-04-17 14:21:20', '2013-04-23 15:29:25', 16414, '79166145440');\n" +
                    "insert into TerminalDevice(terminalDeviceID , dateFrom , dateTo , tariffPlanID , msisdn)\n" +
                    "values(100571740, '2013-04-23 15:29:26', NULL, 16414, '79166145440');\n" +
                    "insert into MarketingCategory(marketingCategoryID , marketingCategoryName)\n" +
                    "values(1180, 'Москва.MVPC');\n" +
                    "insert into MarketingCategory(marketingCategoryID , marketingCategoryName)\n" +
                    "values(1906, 'Москва.Служебные');\n" +
                    "insert into CalculationMethod(calculationMethodID ,calculationMethodName)\n" +
                    "values(1, 'авансовый');\n" +
                    "insert into CalculationMethod(calculationMethodID ,calculationMethodName)\n" +
                    "values(2, 'кредитный');\n" +
                    "insert into CalculationMethod(calculationMethodID ,calculationMethodName)\n" +
                    "values(3, 'предоплаченный');\n" +
                    "insert into TeriffPlan(tariffPlanID , tariffPlanName)\n" +
                    "values(11, 'Москва - Оптима 200 (КТП) (SS)');\n" +
                    "insert into TeriffPlan(tariffPlanID , tariffPlanName)\n" +
                    "values(7776, 'Москва - RED (ПРП) (SS)');\n" +
                    "insert into TeriffPlan(tariffPlanID , tariffPlanName)\n" +
                    "values(8116, 'Москва - RED. (ПРП) (SCP)');\n" +
                    "insert into TeriffPlan(tariffPlanID , tariffPlanName)\n" +
                    "values(10834, 'Москва - RED (ПРП) (SCP)');\n" +
                    "insert into TeriffPlan(tariffPlanID , tariffPlanName)\n" +
                    "values(10839, 'Москва - Бизнес Сеть (гор/фед) (КОРП) (SS)');\n" +
                    "insert into TeriffPlan(tariffPlanID , tariffPlanName)\n" +
                    "values(11245, 'Москва - RED Energy 2011 (ПРП) (SCP)');\n" +
                    "insert into TeriffPlan(tariffPlanID , tariffPlanName)\n" +
                    "values(15634, 'Москва - Супер МТС для своих (ПРП) (SCP)');\n" +
                    "insert into TeriffPlan(tariffPlanID , tariffPlanName)\n" +
                    "values(16414, 'Москва - Служебный (гор/фед) (КОРП) (SS)');";
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

        CrmElemFactory.CrmElemInt crmElemInt1 = Factory.getObject(Long.valueOf("19991478"),ContractFactory.TYPE);
        CrmElemFactory.CrmElemInt crmElemInt2 = Factory.getObject(Long.valueOf("19338396"),PersonalAccountFactory.TYPE);
        CrmElemFactory.CrmElemInt crmElemInt3 = Factory.getObject(Long.valueOf("19115169"),TerminalDeviceFactory.TYPE);
        try{
            crmElemInt1.getRow();
            crmElemInt2.getRow();
            crmElemInt3.getRow();
        } catch (SQLException e){
            System.err.println("Method getRow() faild...");
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println(crmElemInt1);
        System.out.println(crmElemInt2);
        System.out.println(crmElemInt3);

        try{
            JTree tree = new JTree(crmElemInt1.getTree(Timestamp.valueOf("2013-09-01 01:00:00.0")));
            JFrame frame = new JFrame("ТестДерева");
            frame.add(tree);
            frame.setSize(600,300);
            frame.show();
        }catch (SQLException e){
            System.err.println("Дерево...");
            e.printStackTrace();
            System.exit(1);
        }
	}
}