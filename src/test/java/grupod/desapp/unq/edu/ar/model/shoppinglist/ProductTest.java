package grupod.desapp.unq.edu.ar.model.shoppinglist;

import grupod.desapp.unq.edu.ar.model.Price;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {

	private Product product;
	private Price price;
	
	@Before
	public void setUp(){
		product = new Product();
		price = new Price(10,20);
	}

	@Test
	public void testBrand() throws Exception {
		product.setBrand("yogurisimo");
		assertEquals("yogurisimo", product.getBrand());
	}

	@Test
	public void testCategory() throws Exception {
		product.setCategory("Lacteos");
		assertEquals("Lacteos", product.getCategory());
	}

	@Test
	public void testId() throws Exception {
		product.setId(1);
		assertEquals(1, product.getId());
	}

	@Test
	public void testImage() throws Exception {
		product.setImage("URL");
		assertEquals("URL", product.getImage());
	}

	@Test
	public void testName() throws Exception {
		product.setName("Yogur");
		assertEquals("Yogur", product.getName());
	}

	@Test
	public void testPrice() throws Exception {
		product.setPrice(price);
		assertEquals(price, product.getPrice());
	}

	@Test
	public void testStock() throws Exception {
		product.setStock(3);
		assertEquals(3, product.getStock());
	}

	@Test
	public void testTime() throws Exception {
		product.setTime(3);
		assertEquals(3, product.getTime());
	}

	@Test
	public void testCoverage() throws Exception {
		product = new Product(1,"coca","cola",1,price,"imagen","gaseosas");
		assertEquals(price, product.getPrice());
	}
}
