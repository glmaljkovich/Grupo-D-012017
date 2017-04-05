package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {

	private Product product;
	private Price price;
	
	@Before
	public void setUp(){
		product = new Product();
		price = new Price(10,20);
	}
	
	@Test
	public void testProduct() {
		product.setBrand("yogurisimo");
		product.setCategory("Lacteos");
		product.setID("1");
		product.setImage("URL");
		product.setName("Yogur");
		product.setPrice(price);
		product.setStock(3);
		assertEquals("yogurisimo", product.getBrand());
		assertEquals("Lacteos", product.getCategory());
		assertEquals("1", product.getID());
		assertEquals("URL", product.getImage());
		assertEquals("Yogur", product.getName());
		assertEquals(price, product.getPrice());
		assertEquals(10, product.getPrice().getInteger());
		assertEquals(20, product.getPrice().getDecimal());
		assertEquals(3, product.getStock());
	}

}
