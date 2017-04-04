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

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
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
	
	public int getTime(){
		return this.product.getTime()*this.quantity;
	}
	
}