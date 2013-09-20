package iu4.avitikov;

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
			System.err.println("Нe удалось оздать соединение.");
			e.printStackTrace();
			System.exit(1);
		}

		try {
			Statement stat = con.createStatement();
			String query = "CREATE TABLE TestTable (id IDENTITY , value VARCHAR(15))";

			try {
				stat.executeUpdate(query);
			} catch (SQLException e) { }

			query = "INSERT INTO TestTable (value) VALUES('Москва')";
			stat.executeUpdate(query);
			query = "INSERT INTO TestTable (value) VALUES('Ереван')";
			stat.executeUpdate(query);
			query = "INSERT INTO TestTable (value) VALUES('Тбилиси')";
			stat.executeUpdate(query);

			query = "SELECT id, value FROM TestTable";
			ResultSet rs = stat.executeQuery(query);

            /*query = "COMMIT";
            if (stat.execute(query)) {
                System.out.println("COMMIT!");
            }else { System.out.println("COMMIT faild..."); }   */

			while (rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}

			stat.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
