package grupod.desapp.unq.edu.ar.persistence;

import grupod.desapp.unq.edu.ar.model.requests.Request;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gabriel on 16/05/17.
 */
public interface RequestsDAO extends CrudRepository<Request, Integer> {
}
