package grupod.desapp.unq.edu.ar.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Price implements Serializable{
	private int integer;
	private int decimal;
	
	public Price(int integer, int decimal){
		this.integer = integer;
		this.decimal = decimal;
	}

	public Price(){}

	public int getInteger() {
		return integer;
	}

	public void setInteger(int integer) {
		this.integer = integer;
	}

	public int getDecimal() {
		return decimal;
	}

	public void setDecimal(int decimal) {
		this.decimal = decimal;
	}
	
	
}
