package model;

public class ListItem {
	private Product product;
	private int quantity;
	private boolean processed;
	
	public ListItem(){
		
	}
	
	public ListItem(Product product, int quantity) {
		this.product 	= product;
		this.quantity 	= quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setProcessed(){
		this.processed=true;
	}
	public int getTime(){
		return this.product.getTime()*this.quantity;
	}
	
}