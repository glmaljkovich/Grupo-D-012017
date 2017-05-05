package grupod.desapp.unq.edu.ar.model;

import grupod.desapp.unq.edu.ar.model.shoppinglist.ShoppingList;

public interface Threshold {
	public boolean shouldFireAlert(ShoppingList list);
	
	// Configurable con porcentaje, categoria, cantidad de compras hacia atrás.
	// Editable.
}
