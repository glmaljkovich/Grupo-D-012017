package model;

import static org.junit.Assert.*;

import model.user.Client;
import org.junit.Before;
import org.junit.Test;

public class RequestTest {
	private Request request;
	private Client client;
	private ShoppingList shoppingList;
	
	@Before
	public void setUp() throws Exception {
		client 			= new Client();
		shoppingList 	= new ShoppingList();
		request 		= new Request();
		shoppingList.setId(1);
	}
	
	@Test
	public void testShoppingList() {
		request.setShoppingList(shoppingList);
		assertEquals(shoppingList.getId(),request.getShoppingList().getId());
		assertEquals(shoppingList,request.getShoppingList());
	}
	
	@Test
	public void testDuration() {
		request.setDuration(10);
		assertEquals(10,request.getDuration());
	}
	
	@Test
	public void testClient() {
		request.setClient(client);
		assertEquals(client,request.getClient());
	}
	
	@Test
	public void testRequest() {
		client 			= new Client();
		shoppingList 	= new ShoppingList();
		request 		= new Request(client,shoppingList);
		assertEquals(client,request.getClient());
		assertEquals(shoppingList,request.getShoppingList());
	}
	 
}
