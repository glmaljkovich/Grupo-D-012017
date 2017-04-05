package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PriceTest {

	private Price price;
	
	@Before
	public void setUp(){
		price = new Price(10,20); 
	}
	
	@Test
	public void testInteger() {
		assertEquals(10, price.getInteger());
		price.setInteger(100);
		assertEquals(100, price.getInteger());
	}
	
	@Test
	public void testDecimal() {
		assertEquals(20, price.getDecimal());
		price.setDecimal(200);
		assertEquals(200, price.getDecimal());
	}	
}
