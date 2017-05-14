package grupod.desapp.unq.edu.ar.persistence;

import grupod.desapp.unq.edu.ar.model.user.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by gabriel on 02/05/17.
 */
@Transactional
public interface UserDAO extends CrudRepository<User, Long> {

    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automagically generated from its signature by Spring Data JPA.
     */
    public User findByEmail(String email);

    public User findByUsernameAndPassword(String username, String password);

    public User findByUsername(String username);

    public User findById(long id);


}