package model.offer;

import model.ListItem;
import model.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by gabriel on 10/04/17.
 */
public class ProductOfferTest {
    ProductOffer offer;
    ListItem item;
    Product product;

    @Before
    public void setUp(){
        offer   = new ProductOffer();
        item    = mock(ListItem.class);
        product = mock(Product.class);

        when(item.getProduct()).thenReturn(product);
    }

    @Test
    public void appliesToItem() throws Exception {
        offer.setProduct(product);

        assertTrue(offer.appliesTo(item));
    }

    @Test
    public void setProduct() throws Exception {
        offer.setProduct(product);

        assertEquals(product, offer.getProduct());
    }

}