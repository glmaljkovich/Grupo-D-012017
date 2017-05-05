package grupod.desapp.unq.edu.ar.services;


import grupod.desapp.unq.edu.ar.model.user.User;
import grupod.desapp.unq.edu.ar.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDAO userDao;


    /**
     * GET /create  --> Create a new user and save it in the database.
     */
    @RequestMapping(method = POST, headers = "content-type=application/json")
    @ResponseBody
    public String create(@RequestBody User user) {
        String userId = "";
        try {
            userDao.save(user);
            userId = String.valueOf(user.getId());
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created with id = " + userId;
    }

    /**
     * GET /delete  --> Delete the user having the passed id.
     */
    @RequestMapping(method = DELETE, headers = "content-type=application/json")
    @ResponseBody
    public String delete(long id) {
        try {
            User user = userDao.findById(id);
            userDao.delete(user);
        }
        catch (Exception ex) {
            return "Error deleting the user: it doesn't exist";
        }
        return "User succesfully deleted!";
    }

    /**
     * GET /get-by-email  --> Return the id for the user having the passed
     * email.
     */
    @RequestMapping(value = "/get-by-email", method = GET)
    @ResponseBody
    public String getByEmail(String email) {
        String userId = "";
        try {
            User user = userDao.findByEmail(email);
            userId = String.valueOf(user.getId());
        }
        catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId;
    }

    /**
     * GET /update  --> Update the email and the name for the user in the
     * database having the passed id.
     */
    @RequestMapping(method = PUT, headers = "content-type=application/json")
    @ResponseBody
    public String updateUser(@RequestBody User updated) {
        try {
            User user = userDao.findOne(updated.getId());
            user.setEmail(updated.getEmail());
            user.setUsername(updated.getUsername());
            userDao.save(user);
        }
        catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }

    // Private fields



}
