package grupod.desapp.unq.edu.ar.services;


import grupod.desapp.unq.edu.ar.model.user.User;
import grupod.desapp.unq.edu.ar.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDAO userDao;


    /**
     * Create a new user and save it in the database.
     */
    @RequestMapping(method = POST, headers = "content-type=application/json")
    public ResponseEntity create(@RequestBody User user) {
        ResponseEntity response;
        if(userDao.findByUsername(user.getUsername()) != null){
            response = ResponseEntity.badRequest().body("Usuario existente.");
        }else{
            try {
                userDao.save(user);
                response = ResponseEntity.ok(user.getToken());
            }
            catch (Exception ex) {
                response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar su pedido.");
            }
        }

        return response;
    }

    /**
     * Delete the user having the passed id.
     */
    @RequestMapping(method = DELETE, headers = "content-type=application/json")
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
     * Return the token for the user.
     */
    @RequestMapping(value = "/login", method = POST)
    public ResponseEntity login(@RequestBody User user) {
        String userToken = null;
        try {
            User result = userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
            userToken = result.getToken();
        }
        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Username or Password.");
        }
        return ResponseEntity.ok(userToken);
    }

    /**
     * Update the email and the name for the user in the
     * database having the passed id.
     */
    @RequestMapping(method = PUT, headers = "content-type=application/json")
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
