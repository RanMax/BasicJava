package org.basicjava.rt4.samoilov.localHostDB;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBConnection {
	
	public static Scanner sc = new Scanner(System.in);
	public static Connection conn;
	
	//�����������
	public DBConnection() {
		//����������� �������� jdbc
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} 
		catch (InstantiationException e) {
			e.printStackTrace();
		} 
		catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		out.println("������� JDBC ������� ��������");
		
		//���������� � ��
		try {
			
			DBConnection.conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		out.println("���������� � �� �����������\n");		
		
	}//end of CONSTRUCTOR
	
	//������ ����� ������������
	private String readUserInput() {
		out.print("������� ��� � ������� ��� ����� ������ � �� [��� �������]: ");
		String s = sc.nextLine();
		return s;
	}	
	
	//������ ������� �� ��
	public void printDataBase() throws SQLException {
		out.println("���\t\t�������");
		
		//sql-������
		String sql = "SELECT first_name, second_name FROM test.users";
		Statement statement = conn.createStatement();
		
		//��������� ������ �� ��
		ResultSet result = statement.executeQuery(sql);
		
		result.next();
		do {
			//String id = result.getString(1);
			String firstName = result.getString(1);
			String secondName = result.getString(2);
			out.printf("%s\t\t%s\n",  firstName, secondName);
		}
		while (result.next());		
	}	
	
	//���������� ������ � ��
	public void insertToDB() throws SQLException {
		//��������� ������ ����� �� ����� ������������
		//���� ������������ ����������� ���������
		String[] input = readUserInput().split(" ");
		
		if (input[0] != null && input[1] != null) {
			//sql-������
			String sql = "INSERT INTO test.users(`first_name`,`second_name`)VALUES(\""+input[0]+"\", \""+input[1]+"\");";
			Statement statement = conn.createStatement();
			
			//���������� sql-�������
			statement.execute(sql);
			out.printf("������ \"%s %s\" ������� ��������� � ��\n\n", input[0], input[1]);	
		}
		else
			out.println("���������� ��������� ���������� ������ - ������� ���� ���� ������");
	}//end of INSERTtOdb
}
