package model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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
    public void setItems() throws Exception {
        shoppingList.setItems(list);

        assertEquals(list, shoppingList.getItems());
    }

}