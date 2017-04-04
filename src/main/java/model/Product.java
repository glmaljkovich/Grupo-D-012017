package model;

public class Product {
	private String ID;
	private String name;
	private String brand;
	private int stock;
	private Price price;
	private String image;
	private String category;
	
	public Product(String ID,String name,String brand,int stock,Price price,String image,String category){
		this.ID = ID;
		this.name = name;
		this.brand = brand;
		this.stock = stock;
		this.price = price;
		this.image = image;
		this.category = category;
	}
	
	public Product(){
		//this.category = category;
		//this.name = name;
		//this.price = price;
		//this.stock = stock;
		//this.brand = brand;
		//this.image = image;
		//this.barcode = barcode;
	}
	
	public int getTime(){
		return 1;
	}
	
}
