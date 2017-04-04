package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	private User user;
	private String password;
	private String username;
	private AccessLevel level;
	
	@Before
	public void setUp(){
		user 		= new User();
		username 	= "pepe";
		password 	= "1234";
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
		User user2 = new User(username, password, level);
		
		assertEquals(level, user2.getAccessLevel());
	}
	

}
