package grupod.desapp.unq.edu.ar.controllers;


import grupod.desapp.unq.edu.ar.model.exceptions.UserAlreadyExistsException;
import grupod.desapp.unq.edu.ar.model.user.User;
import grupod.desapp.unq.edu.ar.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Create a new user and save it in the database.
     */
    @PostMapping(headers = "content-type=application/json")
    public ResponseEntity create(@RequestBody User user) {
        ResponseEntity response;
        try {
            userService.add(user);
            response = ResponseEntity.ok(user.getToken());
        }
        catch (UserAlreadyExistsException ex){
            ex.printStackTrace();
            response = ResponseEntity.badRequest().body("Usuario existente.");
        }
        catch (Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar su pedido.");
        }
        return response;
    }

    /**
     * Delete the user having the passed id.
     */
    @DeleteMapping(headers = "content-type=application/json")
    public ResponseEntity delete(long id) {
        try {
           userService.delete(id);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error deleting the user: it doesn't exist");
        }
        return ResponseEntity.ok("User succesfully deleted!");
    }

    /**
     * Return the token for the user having the passed
     * email.
     */
    @GetMapping(value = "/get-by-email")
    public ResponseEntity getByEmail(String email) {
        String token;
        try {
            token = userService.findByEmail(email);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body("User not found");
        }
        return ResponseEntity.ok(token);
    }

    
    /**
     * Return the token for the user.
     */
    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody User user) {
        String userToken = null;
        try {
            userToken = userService.login(user);
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
    public ResponseEntity updateUser(@RequestBody User updated) {
        try {
            userService.update(updated);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body("Error updating the user");
        }
        return ResponseEntity.ok("User succesfully updated!");
    }

}
