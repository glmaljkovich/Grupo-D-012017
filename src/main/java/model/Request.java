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
	}

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<ListItem> getList() {
		return shoppingList.getListItem();
	}
	public void setList(ShoppingList list) {
		this.shoppingList = list;
	}
	public int timeRequest(){
		this.getList().forEach(product -> duration += product.getTime());
		return duration;
	}
	
}