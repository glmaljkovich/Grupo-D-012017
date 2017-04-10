package model.user;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import model.ShoppingList;
import model.user.Client;
import model.user.Profile;
import org.junit.Before;
import org.junit.Test;

public class ClientTest {
	private Client client;
	private List<ShoppingList> lists;
	private Profile profile;
	
	@Before
	public void setUp(){
		client = new Client("pepe", "1234");
		lists = new ArrayList<>();
		profile = mock(Profile.class);
	}
	
	@Test
	public void testFirstTime() {
		client.setFirstTime(true);
		assertTrue(client.isFirstTime());
	}
	
	@Test
	public void testShoppingList() {
		client.setShoppingLists(lists);
		assertEquals(lists, client.getShoppingLists());
	}
	
	@Test
	public void testAddress() {
		client.setProfile(profile);
		assertEquals(profile, client.getProfile());
	}
}
