package grupod.desapp.unq.edu.ar.model.shoppinglist;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "shoppingLists")
public class ShoppingList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	@ElementCollection(targetClass=ListItem.class)
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