package grupod.desapp.unq.edu.ar.persistence;

import javax.transaction.Transactional;

import grupod.desapp.unq.edu.ar.model.shoppinglist.ShoppingList;
import grupod.desapp.unq.edu.ar.model.user.User;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ShoppingListDAO extends CrudRepository<ShoppingList, Integer>  {

	public ShoppingList findById(int id);
}
