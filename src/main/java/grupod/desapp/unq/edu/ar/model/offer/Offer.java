package grupod.desapp.unq.edu.ar.model.offer;

import grupod.desapp.unq.edu.ar.model.shoppinglist.ListItem;
import grupod.desapp.unq.edu.ar.model.shoppinglist.ShoppingList;

import java.time.LocalDate;

public abstract class Offer {
	private LocalDate startDate;
	private LocalDate endDate;
	private double discount;

	public Offer(){

	}

	public Offer(LocalDate startDate, LocalDate endDate, double discount) {
		this.startDate 	= startDate;
		this.endDate 	= endDate;
		this.discount 	= discount;
	}

	public abstract boolean appliesTo(ListItem item);

	public abstract boolean appliesTo(ShoppingList list);

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
}
