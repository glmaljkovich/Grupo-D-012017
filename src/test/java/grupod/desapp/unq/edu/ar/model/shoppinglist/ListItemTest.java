package grupod.desapp.unq.edu.ar.model.shoppinglist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListItemTest {

	private ListItem listItem;
	private Product product;
	private int quantity;
	private int time;

	@Before
	public void setUp(){
		product 	= mock(Product.class);
		quantity 	= 10;
		time 		= 5;
		listItem 	= new ListItem();

		when(product.getTime()).thenReturn(time);
		
	}
	
	@Test
	public void testProductListItem() {
		listItem.setProduct(product);
		assertEquals(product, listItem.getProduct());
	}
	
	@Test
	public void testQuantityListItem() {
		listItem = new ListItem(product, 5);

		listItem.setQuantity(quantity);
		assertEquals(quantity, listItem.getQuantity());
	}

	@Test
	public void testGetTime() throws Exception {
		listItem.setProduct(product);
		listItem.setQuantity(quantity);

		assertEquals(time*quantity, listItem.getTime());
	}

	@Test
	public void testSetChecked() throws Exception {
		listItem.setChecked(true);

		assertTrue(listItem.isChecked());
	}
}
