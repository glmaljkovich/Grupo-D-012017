package model;

import java.util.List;

public class Request {
	private Client client;
	private ShoppingList shoppingList;
	private int duration;
	
	public Request(){
		
	}
	
	public Request(Client client, ShoppingList shoppingList) {
		this.client = client;
		this.shoppingList = shoppingList;
		this.setDuration();
	}
	
	private void setDuration(){
		this.getList().forEach(product -> duration += product.getTime());
	}

	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<ListItem> getList() {
		return shoppingList.getListItemList();
	}
	
	public void setShoppingList(ShoppingList list) {
		this.shoppingList = list;
	}
	public int getDuration(){
		return duration;
	}
	
}