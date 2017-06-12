package grupod.desapp.unq.edu.ar.services;

import grupod.desapp.unq.edu.ar.model.exceptions.UserAlreadyExistsException;
import grupod.desapp.unq.edu.ar.model.user.User;
import grupod.desapp.unq.edu.ar.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

/**
 * Created by gabriel on 23/05/17.
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDao;

    public User add(User user) throws UserAlreadyExistsException {
        if(userDao.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistsException();
        }
        userDao.save(user);
        return user;
    }

    public void delete(String username){
        User user = userDao.findByUsername(username);
        userDao.delete(user);
    }

    public String findByEmail(String email){
        User user = userDao.findByEmail(email);
        return user.getToken();
    }

    public User login(User user) throws AuthenticationException{
        User existent = userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(existent == null)
            throw new BadCredentialsException("Invalid Username or Password.");
        return existent;
    }

    public void update(User updated){
        User user = userDao.findOne(updated.getId());
        user.setEmail(updated.getEmail());
        user.setUsername(updated.getUsername());
        userDao.save(user);
    }
}
