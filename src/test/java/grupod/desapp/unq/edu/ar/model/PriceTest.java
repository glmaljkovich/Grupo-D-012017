package grupod.desapp.unq.edu.ar.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
