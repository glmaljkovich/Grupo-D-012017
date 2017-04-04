package model;

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
		request 		= new Request(client, shoppingList);
	}
	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}
