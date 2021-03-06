package grupod.desapp.unq.edu.ar.persistence;

import grupod.desapp.unq.edu.ar.model.shoppinglist.ShoppingList;
import grupod.desapp.unq.edu.ar.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ShoppingListDAO extends CrudRepository<ShoppingList, Integer>  {

	public ShoppingList findById(int id);

	public List<ShoppingList> findByUser(User user);

}
