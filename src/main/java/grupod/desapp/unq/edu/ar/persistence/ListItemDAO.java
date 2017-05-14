package grupod.desapp.unq.edu.ar.persistence;

import grupod.desapp.unq.edu.ar.model.shoppinglist.ListItem;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gabriel on 14/05/17.
 */
public interface ListItemDAO extends CrudRepository<ListItem, Integer> {
    public ListItem getById(int id);
}

