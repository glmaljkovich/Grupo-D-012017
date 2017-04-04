package model;

public class Request {
	private Client client;
	private ShoppingList shoppingList;
	
	public Request(){
		
	}
	
	public Request(Client client, ShoppingList shoppingList) {
		this.client = client;
		this.shoppingList = shoppingList;
	}

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public ShoppingList getList() {
		return shoppingList;
	}
	public void setList(ShoppingList list) {
		this.shoppingList = list;
	}
	
	
	
}