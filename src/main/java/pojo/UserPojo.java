package pojo;

public class UserPojo {
	
	private int userID;
	private String username;
	private String password;
	private String fullName;
	private String email;
	private int role_id;
	private String role;
	
	public UserPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserPojo(int userID, String username, String password, String fullName, String email, int role_id) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.role_id = role_id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserPojo [userID=" + userID + ", username=" + username + ", fullName=" + fullName + ", email=" + email
				+ ", role_id=" + role_id + ", role=" + role + "]";
	}

}
