package grupod.desapp.unq.edu.ar.model.shoppinglist;

import com.fasterxml.jackson.annotation.JsonProperty;
import grupod.desapp.unq.edu.ar.model.exceptions.ItemAlreadyExistsException;
import grupod.desapp.unq.edu.ar.model.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Entity
@Table(name = "shoppingLists")
public class ShoppingList implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	private String name;
	@Column(length = 2000)
	@JsonProperty(access = WRITE_ONLY)
	private User user;

	@Column
	@ElementCollection(targetClass=ListItem.class)
	private List<ListItem> list;

	public ShoppingList(String name, User user, List<ListItem> listItem){
		this.name = name;
		this.user = user;
		this.list = listItem;
	}

	public ShoppingList(){
		this.list = new ArrayList<>();
	}

	public ShoppingList(String name){
		this.name = name;
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

	public void addItem(ListItem item) throws ItemAlreadyExistsException {
		if(this.hasItem(item)){
			throw new ItemAlreadyExistsException();
		}else{
			list.add(item);
		}
	}

	public boolean hasItem(ListItem item){
		return list.stream().anyMatch(element -> element.getProduct().getId() == item.getProduct().getId());
	}

	public void removeItem(ListItem item){
		list.remove(item);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}