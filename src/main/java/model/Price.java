package model;

public class Price {
	private int integer;
	private int decimal;
	
	public Price(int integer, int decimal){
		this.integer = integer;
		this.decimal = decimal;
	}

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
