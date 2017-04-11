package model;

import model.shoppinglist.ShoppingList;

public interface Threshold {
	public boolean shouldFireAlert(ShoppingList list);
	
	// Configurable con porcentaje, categoria, cantidad de compras hacia atrás.
	// Editable.
}
