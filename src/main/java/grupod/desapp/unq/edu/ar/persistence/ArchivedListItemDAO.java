package grupod.desapp.unq.edu.ar.persistence;

import grupod.desapp.unq.edu.ar.model.shoppinglist.ArchivedListItem;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gabriel on 11/06/17.
 */
public interface ArchivedListItemDAO extends CrudRepository<ArchivedListItem, Integer> {
    public ArchivedListItem getById(Integer id);
}
