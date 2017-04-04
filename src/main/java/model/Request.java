package model;

public class Request {
//
	private ShoppingList shoppingList;
	private Client client;
	
	public Client getClient(){
		return client;
	}
	public void setClient(Client client){
		this.client = client;
	}
	public ShoppingList getList(){
		return this.shoppingList;
	}
	public void setShoppingList(ShoppingList shoppingList){
		this.shoppingList = shoppingList;
	}
}
