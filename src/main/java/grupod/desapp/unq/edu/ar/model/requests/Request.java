package grupod.desapp.unq.edu.ar.model.requests;

import grupod.desapp.unq.edu.ar.model.shoppinglist.ListItem;
import grupod.desapp.unq.edu.ar.model.shoppinglist.ShoppingList;
import grupod.desapp.unq.edu.ar.model.user.Client;
import grupod.desapp.unq.edu.ar.model.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "requests")
public class Request implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int id;
	@Column(length = 1000)
	private User client;
	@Column(length = 2000)
	private ShoppingList shoppingList;
	private int duration;
	
	public Request(){
		
	}
	
	public Request(Client client, ShoppingList shoppingList) {
		this.client = client;
		this.shoppingList = shoppingList;
		this.initializeDuration();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void initializeDuration(){
		this.getList().forEach(product -> duration += product.getTime());
	}

	public User getClient() {
		return client;
	}
	
	public void setClient(User client) {
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