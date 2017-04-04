package model;

import java.util.List;

public class ShoppingList {
	private int id;
	private List<ListItem> list;
	
	
	public int getLengthList(){
		return this.getList().size();
	}
	public List<ListItem> getList(){
		return list;
	}
}
