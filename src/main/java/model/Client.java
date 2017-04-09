package model;

import java.util.List;

public class Client extends User {
	private boolean firstTime;
	private List<ShoppingList> shoppingLists;
	private String address;
	
	public Client(){
		
	}
	
	public Client(String username, String password){
		super(username, password, AccessLevel.CLIENT);
		this.setFirstTime(true);
	}


	public boolean isFirstTime() {
		return firstTime;
	}


	public void setFirstTime(boolean firstTime) {
		this.firstTime = firstTime;
	}


	public List<ShoppingList> getShoppingLists() {
		return shoppingLists;
	}


	public void setShoppingLists(List<ShoppingList> shoppingLists) {
		this.shoppingLists = shoppingLists;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}