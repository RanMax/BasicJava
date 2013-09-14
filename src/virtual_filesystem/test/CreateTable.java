package virtual_filesystem.test;

import java.sql.*;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 26.12.12
 * Time: 11:41
 * To change this template use File | Settings | File Templates.
 */
public class CreateTable {
    public static void main(String[] args) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsqldb/test", "sa", "");
        Statement st = conn.createStatement();
        //String query = "INSERT INTO locations (loc_id,cat_id,loc_root_path,priority) VALUES(1,1,'D:/locations/КартинкиМакса',1)";
        String query = "INSERT INTO catalogs (cat_id,cat_nat_id,cat_seq,cat_name) VALUES(2,'http://www.mchernov.com/catalogs/video',0,'Видео Макса')";
        //String query = "SELECT loc_id FROM locations";
        //String query = "TRUNCATE TABLE locations";
        st.execute(query);


        /*ResultSet set = st.executeQuery(query);
        while (set.next()){
            System.out.println(set.getInt("loc_id"));
        }*/

        st.close();
        conn.close();
    }
}
