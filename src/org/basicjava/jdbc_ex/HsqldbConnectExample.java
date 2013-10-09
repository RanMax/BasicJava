package org.basicjava.jdbc_ex;

import java.sql.*;

/**
 * User: Maxim
 * Date: 19.12.12
 * Time: 9:08
 */
/* Пример подключения к HSQLDB*/
public class HsqldbConnectExample {
    public static void main(String[] args) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsqldb/test", "sa","");
        Statement stmt = conn.createStatement();
        //ResultSet rset = stmt.executeQuery("select BANNER from sys.v_$version");
        //stmt.execute("CREATE TABLE test (tes_id INTEGER, test_name VARCHAR(255))");

        //stmt.execute("INSERT INTO test VALUES(1, 'Maxim')");

        ResultSet resSet = stmt.executeQuery("select tes_id,test_name from test");
        while ( resSet.next() )
            System.out.println(resSet.getString("tes_id") + "|" + resSet.getString("test_name"));
        stmt.close();
        conn.close();
    }
}
