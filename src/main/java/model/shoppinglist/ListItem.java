package model.shoppinglist;

public class ListItem {
	private Product product;
	private int quantity;
	private boolean checked;

	public ListItem(){
		this.checked = false;
	}
	
	public ListItem(Product product, int quantity) {
		this.product 	= product;
		this.quantity 	= quantity;
		this.checked 	= false;
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

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
}