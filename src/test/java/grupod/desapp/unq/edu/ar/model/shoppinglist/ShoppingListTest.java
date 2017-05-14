package grupod.desapp.unq.edu.ar.model.shoppinglist;

import grupod.desapp.unq.edu.ar.model.user.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by gabriel on 10/04/17.
 */
public class ShoppingListTest {
    private ShoppingList shoppingList;
    private int id;
    private List<ListItem> list;

    @Before
    public void setUp() throws Exception {
        id              = 1;
        shoppingList    = new ShoppingList();
        list            = new ArrayList<>();
    }

    @Test
    public void setId() throws Exception {
        shoppingList.setId(id);

        assertEquals(id, shoppingList.getId());
    }

    @Test
    public void setName() throws Exception {
        String name = "compras";

        shoppingList.setName(name);

        assertEquals(name, shoppingList.getName());
    }

    @Test
    public void setUser() throws Exception {
        User user = new User();

        shoppingList.setUser(user);

        assertEquals(user, shoppingList.getUser());
    }

    @Test
    public void setItems() throws Exception {
        shoppingList.setItems(list);

        assertEquals(list, shoppingList.getItems());
    }

    @Test
    public void addItem() throws Exception {
        ListItem item = mock(ListItem.class);

        shoppingList.addItem(item);

        assertEquals(item, shoppingList.getItems().get(0));
    }

    @Test
    public void removeItem() throws Exception {
        ListItem item = mock(ListItem.class);

        shoppingList.addItem(item);
        shoppingList.removeItem(item);

        assertEquals(0, shoppingList.getItems().size());
    }

}