package grupod.desapp.unq.edu.ar.services;

import grupod.desapp.unq.edu.ar.model.exceptions.UserAlreadyExistsException;
import grupod.desapp.unq.edu.ar.model.user.Profile;
import grupod.desapp.unq.edu.ar.model.user.User;
import grupod.desapp.unq.edu.ar.persistence.ProfileDAO;
import grupod.desapp.unq.edu.ar.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gabriel on 23/05/17.
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDao;

    @Autowired
    private ProfileDAO profileDAO;

    @Transactional
    public User add(User user) throws UserAlreadyExistsException {
        if(userDao.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistsException();
        }
        Profile profile = new Profile();
        profileDAO.save(profile);
        user.setProfile(profile);
        userDao.save(user);
        return user;
    }

    @Transactional
    public void delete(String username){
        User user = userDao.findByUsername(username);
        userDao.delete(user);
    }

    @Transactional
    public String findByEmail(String email){
        User user = userDao.findByEmail(email);
        return user.getToken();
    }

    @Transactional
    public User login(User user) throws AuthenticationException{
        User existent = userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(existent == null)
            throw new BadCredentialsException("Invalid Username or Password.");
        return existent;
    }

    @Transactional
    public void update(User updated){
        User user = userDao.findOne(updated.getId());
        user.setEmail(updated.getEmail());
        user.setUsername(updated.getUsername());
        userDao.save(user);
    }

    @Transactional
    public Profile getProfile(String username){
        User user = userDao.findByUsername(username);
        Profile profile = user.getProfile();
        if(profile != null)
            return profileDAO.findById(profile.getId());
        return null;
    }

    @Transactional
    public void updateProfile(Profile profile){
        profileDAO.save(profile);
    }
}
