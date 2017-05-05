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
		price.setInteger(100);
		assertEquals(100, price.getInteger());
	}
	
	@Test
	public void testDecimal() {
		price.setDecimal(200);
		assertEquals(200, price.getDecimal());
	}	
}
