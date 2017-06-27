package grupod.desapp.unq.edu.ar.model;

import grupod.desapp.unq.edu.ar.model.shoppinglist.ShoppingList;

import java.io.Serializable;


public interface Threshold extends Serializable{
	public boolean shouldFireAlert(ShoppingList list);
	
	// Configurable con porcentaje, categoria, cantidad de compras hacia atrás.
	// Editable.
}
