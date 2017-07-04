package grupod.desapp.unq.edu.ar.model.shoppinglist;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;


@Entity
@Table(name = "archivedShoppingLists")
public class ArchivedShoppingList implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String name;
    @Column(length = 1000)
    @JsonProperty(access = WRITE_ONLY)
    private String username;

    @Column
    @ElementCollection(targetClass=ArchivedListItem.class)
    @NotNull
    private List<ArchivedListItem> list;

    public ArchivedShoppingList(String name, String username) {
        this.name       = name;
        this.username   = username;
        this.list       = new ArrayList<>();
    }

    public ArchivedShoppingList(){
        this.list       = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ArchivedListItem> getItems() {
        return list;
    }

    public void setItems(List<ArchivedListItem> list) {
        this.list = list;
    }

    public boolean hasItem(ListItem item){
        return list.stream().anyMatch(element -> element.getProductID() == item.getProduct().getId());
    }
}
