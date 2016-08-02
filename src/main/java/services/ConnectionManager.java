package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	static Connection con = null;
	static String DB_URL = "jdbc:mysql://localhost:3306/carsales";
	final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String USER = "root";
	final static String Password = "1234";
	
	public static Connection getConnection() {
		
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USER, Password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
		
	}

}
