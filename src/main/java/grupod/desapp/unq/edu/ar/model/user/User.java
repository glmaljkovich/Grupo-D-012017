package grupod.desapp.unq.edu.ar.model.user;

import org.springframework.util.DigestUtils;
import sun.security.provider.MD5;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private String username;
	private String password;
	private String email;
	private AccessLevel accessLevel;
	
	public User(){
		
	}

	public User(String username, String password, String email){
		this.username 	= username;
		this.password 	= password;
		this.email 		= email;
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

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken(){
		String hash = this.username + this.password;

		return DigestUtils.md5DigestAsHex(hash.getBytes());
	}

}
