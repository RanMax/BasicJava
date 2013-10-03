package iu4.avetikov.crm_elem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
        protected Integer id;

        public AbstractCrmElem(Integer id){
            this.id = id;
        }
        public Integer getId(){
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
           	    connection = DriverManager.getConnection("jdbc:hsqldb:file:dbpath/dbname", "SA", "");
            } catch (SQLException e) {
           	    System.err.println("Нe удалось cоздать соединение.");
           	    e.printStackTrace();
           	    System.exit(1);
            }

            try {
               	statement = connection.createStatement();
            }catch (SQLException e){
                    statement.close();
                    connection.close();
            }
        }
    }
}
