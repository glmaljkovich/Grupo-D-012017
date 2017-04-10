package model.user;

import model.ShoppingList;

import java.util.List;

public class Client extends User {
	private boolean firstTime;
	private List<ShoppingList> shoppingLists;
	private Profile profile;
	
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

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
}