package org.basicjava.jdbc_ex;

import java.sql.*;

/**
 * User: Maxim
 * Date: 17.12.12
 * Time: 16:04
 */
/* Пример подключения к Oracle*/
public class OracleConnectExample {
    public static void main(String args[]) throws SQLException{
        //DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Ranma","mchernov","ranakane");
        Statement stmt = conn.createStatement();
        //ResultSet rset = stmt.executeQuery("select BANNER from sys.v_$version");
        ResultSet resSet = stmt.executeQuery("select first_name from hr.employees");
        while ( resSet.next() )
            System.out.println(resSet.getString(1));
        stmt.close();
    }
}
