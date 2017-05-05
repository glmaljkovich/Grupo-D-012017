package model.user;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	private User user;
	private String password;
	private String username;
	private AccessLevel level;
	private String email;
	
	@Before
	public void setUp(){
		user 		= new User();
		username 	= "pepe";
		password 	= "1234";
		email 		= "pe@pe.com";
		level 		= AccessLevel.ADMIN;
	}

	@Test
	public void testSetUsername() {
		user.setUsername(username);
		assertEquals(username, user.getUsername());
	}
	
	@Test
	public void testSetPassword() {		
		user.setPassword(password);
		assertEquals(password, user.getPassword());
	}
	
	@Test
	public void testSetId() {		
		user.setId(1);
		assertEquals(1, user.getId());
	}
	
	@Test
	public void testGetAccessLevel() {
		user = new User(username, password, level);

		assertEquals(level, user.getAccessLevel());
	}

	@Test
	public void testSetAccessLevel() throws Exception {
		user.setAccessLevel(level);

		assertEquals(level, user.getAccessLevel());
	}

	@Test
	public void testSetEmail() throws Exception {
		user.setEmail(email);

		assertEquals(email, user.getEmail());
	}
}
