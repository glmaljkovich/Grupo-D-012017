package grupod.desapp.unq.edu.ar.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.DigestUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Entity
@Table(name = "users")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private String username;
	@JsonProperty(access = WRITE_ONLY)
	private String password;
	private String email;
	private AccessLevel accessLevel;
	private boolean firstTime;
	@Column(length = 1000)
	private Profile profile;
	
	public User(){
		this.accessLevel = AccessLevel.CLIENT;
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

	public boolean isFirstTime() {
		return firstTime;
	}

	public void setFirstTime(boolean firstTime) {
		this.firstTime = firstTime;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getToken(){
		String hash = this.username + this.password;

		return DigestUtils.md5DigestAsHex(hash.getBytes());
	}

	@Override
	public String toString() {
		return this.username;
	}
}
