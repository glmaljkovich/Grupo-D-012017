package grupod.desapp.unq.edu.ar.model.requests;

import grupod.desapp.unq.edu.ar.model.shoppinglist.ListItem;
import grupod.desapp.unq.edu.ar.model.shoppinglist.ShoppingList;
import grupod.desapp.unq.edu.ar.model.user.Client;

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
		return shoppingList.getItems();
	}
	
	public void setShoppingList(ShoppingList list) {
		this.shoppingList = list;
	}
	public int getDuration(){
		return duration;
	}

	public ShoppingList getShoppingList() {
		return shoppingList;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getShoppingListSize(){
		return this.shoppingList.getItems().size();
	}
}