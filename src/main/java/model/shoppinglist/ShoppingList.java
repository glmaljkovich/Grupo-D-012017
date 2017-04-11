package model.shoppinglist;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
	private int id;
	private List<ListItem> list;
	
	public ShoppingList(int id, List<ListItem> listItem){
		this.id = id;
		this.list = listItem;
	}

	public ShoppingList(){
		this.list = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setItems(List<ListItem> listItem) {
		this.list = listItem;
	}

	public List<ListItem> getItems(){
		return list;
	}
	
	
	
}