package grupod.desapp.unq.edu.ar.model.offer;

import grupod.desapp.unq.edu.ar.model.shoppinglist.ListItem;
import grupod.desapp.unq.edu.ar.model.shoppinglist.Product;
import grupod.desapp.unq.edu.ar.model.shoppinglist.ShoppingList;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by gabriel on 10/04/17.
 */
public class ProductOfferTest {
    private ProductOffer offer;
    private ListItem item;
    private Product product;
    private ShoppingList list;

    @Before
    public void setUp(){
        offer   = new ProductOffer();
        item    = mock(ListItem.class);
        product = mock(Product.class);
        list = mock(ShoppingList.class);

        when(item.getProduct()).thenReturn(product);
        when(list.getItems()).thenReturn(Arrays.asList(item, item));
    }

    @Test
    public void appliesToItem() throws Exception {
        offer.setProduct(product);

        assertTrue(offer.appliesTo(item));
    }

    @Test
    public void appliesToList() throws Exception {
        offer.setProduct(product);

        assertTrue(offer.appliesTo(list));
    }

    @Test
    public void setProduct() throws Exception {
        offer.setProduct(product);

        assertEquals(product, offer.getProduct());
    }

}