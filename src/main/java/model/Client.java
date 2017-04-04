package model;

import java.util.List;

public class Client extends User {
	private boolean firstTime;
	private List<ShoppingList> historyShoppingLists;
	private ShoppingList shoppingList;
	private Profile profile;
	
	public Client(){
		super(AccessLevel.CLIENT);
		
	}
}
