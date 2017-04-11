package model;

public class Product {
	private int id;
	private String name;
	private String brand;
	private int stock;
	private Price price;
	private String image;
	private String category;
	private int time;
	
	public Product(int id, String name, String brand, int stock, Price price, String image, String category){
		this.id = id;
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
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getTime(){
		return this.time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}
