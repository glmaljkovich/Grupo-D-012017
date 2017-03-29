package model;

import java.util.List;

public class Client extends User {
	private boolean firstTime;
	private List<ShoppingList> shoppingLists;
	private String address;
	
	public Client(){
		super(AccessLevel.CLIENT);
		this.firstTime = true;
	}
	
	
}
