package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionManager {
	
private static ThreadLocal<Connection> threadL = new ThreadLocal<>();
static Connection con = null;
static String DB_URL = "jdbc:mysql://localhost:3306/carsales";
final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
final static String USER = "root";
final static String Password = "1234";
	
	public void beginTransaction() {

		try {
			Class.forName(JDBC_DRIVER).newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
			throw new RuntimeException("Cannot load driver", e1);
		}

		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, Password);
			con.setAutoCommit(false);
			threadL.set(con);
		} catch (SQLException e) {
			throw new RuntimeException("Cannot connect to DB", e);
		}
	}

	public void commit() {
		try {
			threadL.get().commit();
			threadL.get().close();
			threadL.remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Cannot commit", e);
		}
	}

	public void rollback() {

		try {
			threadL.get().rollback();
			threadL.get().close();
			threadL.remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Cannot rollback", e);
		}
	}
	
	public Connection getConnection(){
		
		return threadL.get();	
	}

}
