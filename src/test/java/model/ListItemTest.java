package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ListItemTest {

	private ListItem listItem;
	private Product product;
	private int quantity;
	private Product productTwo;
	private Price price;

	@Before
	public void setUp(){
		product = new Product();
		quantity = 10;
		listItem = new ListItem();
		
	}
	
	@Test
	public void testProductListItem() {
		listItem.setProduct(product);
		assertEquals(product,listItem.getProduct());
	}
	
	@Test
	public void testQuantityListItem() {
		listItem.setQuantity(quantity);
		assertEquals(10,listItem.getQuantity());
	}
	
	@Test
	public void testListItem() {
		product = new Product();
		productTwo = new Product("10","cindor","Cindor",100,this.price,"","Lacteos");
		quantity = 100;
		listItem = new ListItem(product,quantity);
		
		assertEquals(100,listItem.getQuantity());
		assertEquals(product,listItem.getProduct());
		listItem.setQuantity(48);
		listItem.setProduct(productTwo);
		assertEquals(productTwo,listItem.getProduct());
	}
}
