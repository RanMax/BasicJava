/*
 * Eclipse EE
 * 01.10.2013 21:51:00
 */

package org.basicjava.test.rt2.samoilov.localHostDB;

//import static java.lang.System.out;

import java.sql.SQLException;

public class Main {
	
	public static void main(String[] args) throws SQLException {	
		
		DBConnection db = new DBConnection();
		db.printDataBase();
		//db.insertToDB();
	}
	
}
