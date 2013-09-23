package iu4.Avetikov;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Mr. Avetik
 * Date: 21.09.13
 * Time: 0:02
 * To change this template use File | Settings | File Templates.
 */

public class DBConnection {
    public static void main(String[] args) {

        ArrayList<Table> TT = new ArrayList<Table>();

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
			               //"CREATE TABLE Terminal_device (terminal_device_id integer , date_from date, date_to date, tariff_plan_id integer, msisdn varchar(15))";
                           //"DROP USER Avet";
                           //"DROP TABLE TestTable";

			/*try {
				stat.execute(query);
			} catch (SQLException e) {
                System.err.println("Не получилось...");
                e.printStackTrace();
                System.exit(1);
            }*/


			query = "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (19115169, to_date('24-08-2006 17:10:47'), to_date('30-09-2006 20:50:41'), 7776, '79197748564');" +
                    "" +
                    "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (19115169, to_date('30-09-2006 20:50:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-05-2007 21:49:05', 'dd-mm-yyyy hh24:mi:ss'), 7776, '79197748564');" +
                    "" +
                    "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (19115169, to_date('01-05-2007 21:49:06', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-07-2009 02:14:04', 'dd-mm-yyyy hh24:mi:ss'), 8116, '79197748564');" +
                    "" +
                    "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (19115169, to_date('03-07-2009 02:14:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-07-2010 13:10:41', 'dd-mm-yyyy hh24:mi:ss'), 10834, '79197748564');" +
                    "" +
                    "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (19115169, to_date('02-07-2010 13:10:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-06-2013 09:12:14', 'dd-mm-yyyy hh24:mi:ss'), 11245, '79197748564');" +
                    "" +
                    "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (19115169, to_date('10-06-2013 09:12:15', 'dd-mm-yyyy hh24:mi:ss'), null, 15634, '79197748564');" +
                    "" +
                    "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (19441439, to_date('19-09-2006 08:34:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-03-2010 14:24:42', 'dd-mm-yyyy hh24:mi:ss'), 11, '79165673658');" +
                    "" +
                    "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (19441439, to_date('23-03-2010 14:24:43', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-06-2013 09:12:13', 'dd-mm-yyyy hh24:mi:ss'), 11245, '79165673658');" +
                    "" +
                    "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (19441439, to_date('10-06-2013 09:12:14', 'dd-mm-yyyy hh24:mi:ss'), null, 15634, '79165673658');" +
                    "" +
                    "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (23341333, to_date('26-07-2007 13:13:08', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-09-2007 14:47:25', 'dd-mm-yyyy hh24:mi:ss'), 7776, '79166145440');" +
                    "" +
                    "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (23341333, to_date('27-09-2007 14:47:26', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-05-2008 11:31:49', 'dd-mm-yyyy hh24:mi:ss'), 7776, '79166145440');" +
                    "" +
                    "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (35243861, to_date('24-12-2008 13:32:39', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-01-2009 16:17:15', 'dd-mm-yyyy hh24:mi:ss'), 8678, '79166145440');" +
                    "" +
                    "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (35650364, to_date('16-01-2009 18:06:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-04-2009 16:38:49', 'dd-mm-yyyy hh24:mi:ss'), 10473, '79166145440');" +
                    "" +
                    "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (35650364, to_date('10-04-2009 16:38:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('13-04-2009 20:24:32', 'dd-mm-yyyy hh24:mi:ss'), 10473, '79166145440');" +
                    "" +
                    "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (35650364, to_date('13-04-2009 20:24:33', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-06-2009 10:22:13', 'dd-mm-yyyy hh24:mi:ss'), 10111, '79166145440');" +
                    "" +
                    "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (35650364, to_date('10-06-2009 10:22:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-10-2010 00:17:45', 'dd-mm-yyyy hh24:mi:ss'), 10899, '79166145440');" +
                    "" +
                    "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (100571740, to_date('29-08-2011 15:36:03', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-10-2012 15:35:04', 'dd-mm-yyyy hh24:mi:ss'), 10839, '79166145440');" +
                    "" +
                    "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (100571740, to_date('15-10-2012 15:35:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-04-2013 15:33:50', 'dd-mm-yyyy hh24:mi:ss'), 16414, '79166145440');" +
                    "" +
                    "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (100571740, to_date('15-04-2013 15:33:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-04-2013 14:21:19', 'dd-mm-yyyy hh24:mi:ss'), 16414, '79166145440');" +
                    "" +
                    "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (100571740, to_date('17-04-2013 14:21:20', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-04-2013 15:29:25', 'dd-mm-yyyy hh24:mi:ss'), 16414, '79166145440');" +
                    "" +
                    "insert into terminal_device (TERMINAL_DEVICE_ID, DATE_FROM, DATE_TO, TARIFF_PLAN_ID, MSISDN)" +
                    "values (100571740, to_date('23-04-2013 15:29:26', 'dd-mm-yyyy hh24:mi:ss'), null, 16414, '79166145440');" ;
			stat.executeUpdate(query);


			/*query = "SELECT id, gorod, region FROM TestTable";
			ResultSet rs = stat.executeQuery(query);*/

            /*query = "COMMIT";
            if (stat.execute(query)) {
                System.out.println("COMMIT!");
            }else { System.out.println("COMMIT faild..."); }*/

			/*while (rs.next()) {
                TT.add(new Table(rs.getInt("ID"),rs.getString("gorod"),rs.getString("region")));
			}

            for(int i=0;i<TT.size();i++){
                System.out.println(TT.get(i).toString());
            }*/

            query = "SHUTDOWN";
            stat.execute(query);

            /*rs.close();*/
			stat.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}