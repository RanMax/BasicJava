package localHostDB;

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
	
	//Конструктор
	public DBConnection() {
		//регистрация драйвера jdbc
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
		out.println("Драйвер JDBC успешно загружен");
		
		//соединение с БД
		try {
			
			DBConnection.conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		out.println("Соединение с БД установлено\n");		
		
	}//end of CONSTRUCTOR
	
	//Чтение ввода пользователя
	private String readUserInput() {
		out.print("Введите имя и фамилию для новой записи в БД [имя фамилия]: ");
		String s = sc.nextLine();
		return s;
	}	
	
	//Чтение таблицы из БД
	public void printDataBase() throws SQLException {
		out.println("Имя\t\tФамилия");
		
		//sql-запрос
		String sql = "SELECT first_name, second_name FROM test.users";
		Statement statement = conn.createStatement();
		
		//получение данных из БД
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
	
	//Добавление записи в БД
	public void insertToDB() throws SQLException {
		//Создается массив строк из ввода пользователя
		//Ввод пользователя разбивается пробелами
		String[] input = readUserInput().split(" ");
		
		if (input[0] != null && input[1] != null) {
			//sql-запрос
			String sql = "INSERT INTO test.users(`first_name`,`second_name`)VALUES(\""+input[0]+"\", \""+input[1]+"\");";
			Statement statement = conn.createStatement();
			
			//выполнение sql-запроса
			statement.execute(sql);
			out.printf("Запись \"%s %s\" успешно добавлена в БД\n\n", input[0], input[1]);	
		}
		else
			out.println("Невозможно выполнить добавление записи - минимум одно поле пустое");
	}//end of INSERTtOdb
}
