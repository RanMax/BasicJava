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
			String query = "CREATE TABLE TestTable (id IDENTITY , gorod VARCHAR(15), region VARCHAR(15))";

			try {
				stat.execute(query);
			} catch (SQLException e) {
                System.err.println("Не получилось...");
                e.printStackTrace();
                System.exit(1);
            }


			query = "INSERT INTO TestTable (gorod,region) VALUES('Москва','77')";
			stat.executeUpdate(query);
			query = "INSERT INTO TestTable (gorod,region) VALUES('Ереван','05')";
			stat.executeUpdate(query);
			query = "INSERT INTO TestTable (gorod,region) VALUES('Тбилиси','46')";
			stat.executeUpdate(query);
            query = "INSERT INTO TestTable (gorod,region) VALUES('Минск','84')";
			stat.executeUpdate(query);
            query = "INSERT INTO TestTable (gorod,region) VALUES('Омск','89')";
			stat.executeUpdate(query);
            query = "INSERT INTO TestTable (gorod,region) VALUES('Томск','47')";
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

			stat.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}