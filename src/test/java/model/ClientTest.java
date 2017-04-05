package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ClientTest {
	private Client client;
	private List<ShoppingList> lists;
	private String address;
	
	@Before
	public void setUp(){
		client = new Client("pepe", "1234");
		lists = new ArrayList<>();
		address = "calle falsa 123";
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
		client.setAddress(address);
		assertEquals(address, client.getAddress());
	}
}
