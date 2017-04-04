package model;

import java.util.List;

public class ShoppingList {
	private int id;
	private List<ListItem> listItem;
	
	public ShoppingList(int id, List<ListItem> listItem){
		this.id = id;
		this.listItem = listItem;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<ListItem> getListItem() {
		return listItem;
	}
	public void setListItem(List<ListItem> listItem) {
		this.listItem = listItem;
	}
	public List<ListItem> getListItemList(){
		return this.listItem;
	}
	
	
	
}