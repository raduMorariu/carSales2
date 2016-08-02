package entities;

public class UserBean {
	
	private static String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	public boolean valid;
	
	public UserBean(String username, String password) {
		// TODO Auto-generated constructor stub
	}
	public UserBean() {
		// TODO Auto-generated constructor stub
	}
	public static String getUsername() {
		return username;
	}
	public void setUsername(String newUsername) {
		this.username = newUsername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String newLastName) {
		this.lastName = newLastName;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean newValid) {
		this.valid = newValid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
