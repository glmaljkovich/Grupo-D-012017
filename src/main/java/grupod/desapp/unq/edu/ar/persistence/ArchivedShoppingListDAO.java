package grupod.desapp.unq.edu.ar.persistence;

import grupod.desapp.unq.edu.ar.model.shoppinglist.ArchivedShoppingList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;



@Transactional
public interface ArchivedShoppingListDAO extends CrudRepository<ArchivedShoppingList, Integer> {
    public ArchivedShoppingList findById(int id);

    public Page<ArchivedShoppingList> findByUsername(String username, Pageable pageable);
}
