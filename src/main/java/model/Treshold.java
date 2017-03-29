package model;

public interface Treshold {
	public boolean shouldFireAlert(ShoppingList list);
	
	// Configurable con porcentaje, categoria, cantidad de compras hacia atrás.
	// Editable.
}
