package model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
	private int id;
	private List<ListItem> list;
	
	public List<ListItem> getListItemList(){
		if(list == null){
			return new ArrayList<>();
		}
		return list;
	}
	
	
	
}