package iu4.Avetikov;

import iu4.Avetikov.Factory.TableFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by IntelliJ IDEA.
 * User: Mr. Avetik
 * Date: 21.09.13
 * Time: 13:51
 * To change this template use File | Settings | File Templates.
 */
public class Table{
    protected static Connection connection;
    protected static Statement statement;
    protected String query;
    private TableFactory tableFactory;

    public Table(){}

    public Table(TableFactory tableFactory){
        this.tableFactory = tableFactory;
    }

    public Table getTable(String type){
        Table table = (this.tableFactory).getTable(type);
        return table;
    }

    protected void getRow() throws SQLException {

        try {
            Class.forName("org.hsqldb.jdbcDriver");
        	} catch (ClassNotFoundException e) {
        	    System.err.println("Нe удалось загрузить драйвер ДБ.");
        	    e.printStackTrace();
        		System.exit(1);
        }

        try {
        	connection = DriverManager.getConnection("jdbc:hsqldb:file:dbpath/dbname", "SA", "");
        } catch (SQLException e) {
        	System.err.println("Нe удалось cоздать соединение.");
        	e.printStackTrace();
        	System.exit(1);
        }

        try {
        	statement = connection.createStatement();

        	try {
        		statement.execute(query);
        	} catch (SQLException e) {
                System.err.println("Не получилось...");
                e.printStackTrace();
                System.exit(1);
            }
        }catch (SQLException e){
            try{
            statement.close();
            connection.close();
            } catch (SQLException ex) {}
            System.err.println("Косяк...");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public String toString() { return null; }
}
