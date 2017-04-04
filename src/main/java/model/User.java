package model;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	protected AccessLevel accessLevel;
	
	public User(){
		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	public User(String username, String password, AccessLevel accessLevel){
		this.accessLevel 	= accessLevel;
		this.username 		= username;
		this.password 		= password;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
