package grupod.desapp.unq.edu.ar.persistence;

import grupod.desapp.unq.edu.ar.model.user.Profile;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by gabriel on 27/06/17.
 */
@Transactional
public interface ProfileDAO extends CrudRepository<Profile, Integer> {
    public Profile findById(int id);
}
