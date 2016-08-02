
package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import services.ConnectionManager;
import services.TransactionManager;

public class UserDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null;
	
	public static UserBean login(UserBean bean) {
		Statement stmt = null;
		
		String username = bean.getUsername();
		String password = bean.getPassword();
		
		String searchQuery = "select * from users where username='"
                + username
                + "' AND password='"
                + password
                + "'";
		
		System.out.println("Your username is " + username);
		System.out.println("Your password is " + password);
		System.out.println("Query: " + searchQuery);
		
		try {
			System.out.println("Connecting to DB");
			currentCon = ConnectionManager.getConnection();
			System.out.println("Connected to DB");
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();
			if (!more) {
				System.out.println("Sorry, you are not a registered user! Please sign up first");
				bean.setValid(false);
			} else if (more) {
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				System.out.println("Welcome " + firstName);
				bean.setFirstName(firstName);
				bean.setLastName(lastName);
				bean.setValid(true);
			}
		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred!" + ex);
		} finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (Exception e) {
					rs = null;
				}
				if (stmt!=null) {
					try {
						stmt.close();
					} catch (Exception e) {
						stmt = null;
					}
					if (currentCon!=null) {
						try {
							currentCon.close();
						} catch (Exception e) {
							currentCon = null;
						}
					}
				}
			}
		}
		return bean;
	}
	
	public void userRegister(UserBean user) {
		
		Connection conn = new TransactionManager().getConnection();
		String Sql = "Insert into users (firstName, lastName, email, username, password) values (?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = conn.prepareStatement(Sql);
			st.setString(1, user.getFirstName());
			st.setString(2, user.getLastName());
			st.setString(3, user.getEmail());
			st.setString(4, user.getUsername());
			st.setString(5, user.getPassword());
			st.executeUpdate();
			System.out.println("User registered to DB");
		} catch (SQLException e) {
			throw new RuntimeException("Cannot register user to DB", e);
		}
	}
	
	public UserBean getUserByUsername(String username) {

		String uname = null;
		String pass = null;

		Connection connection = new TransactionManager().getConnection();

		String str = "select username, password from users where username = ?";
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(str);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				uname = rs.getString("username");
				pass = rs.getString("password");
				System.out.println("user from db: " + uname);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Cannot execute querry", e);
		}

		if (uname == null) {
			System.out.println("Inexistent user!");
			return null;
		} else {
			UserBean user = new UserBean(uname, pass);
			return user;
		}
	}

}
 