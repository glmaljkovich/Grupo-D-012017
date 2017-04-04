package model;

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
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<ListItem> getListItem() {
		return list;
	}
	public void setListItem(List<ListItem> listItem) {
		this.list = listItem;
	}
	public List<ListItem> getListItemList(){
		if(list == null){
			return new ArrayList<>();
		}
		return list;
	}
	
	
	
}