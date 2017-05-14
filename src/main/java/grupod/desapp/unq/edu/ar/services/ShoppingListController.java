package grupod.desapp.unq.edu.ar.services;

import grupod.desapp.unq.edu.ar.model.shoppinglist.ShoppingList;
import grupod.desapp.unq.edu.ar.model.user.User;
import grupod.desapp.unq.edu.ar.persistence.ShoppingListDAO;
import grupod.desapp.unq.edu.ar.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/shoppingList")
public class ShoppingListController {

	@Autowired
    private ShoppingListDAO shoppingListDao;

    @Autowired
    private UserDAO userDao;

    /**
     * Create a new shoppingList and save it in the database.
     */
    @PostMapping(value = "/{username}", headers = "content-type=application/json")
    public ResponseEntity create(@RequestBody ShoppingList shoppingList, @PathVariable String username) {
        try {
            User user = userDao.findByUsername(username);
            shoppingList.setUser(user);
            shoppingListDao.save(shoppingList);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error creating the shoppingList");
        }
        return ResponseEntity.ok(shoppingList.getId());
    }

    /**
     * Delete the shoppingList having the passed id.
     */
    @DeleteMapping( headers = "content-type=application/json")
    public ResponseEntity delete(int id) {
        try {
            ShoppingList shoppingList = shoppingListDao.findById(id);
            shoppingListDao.delete(shoppingList);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error deleting the shoppingList: it doesn't exist");
        }
        return ResponseEntity.ok("ShoppingList succesfully deleted!");
    }
    
    /**
     * Return a shoppinglist
     */
    @GetMapping
    public ResponseEntity getById(@RequestParam int id) {
        ShoppingList shopList;
        try {
            shopList = shoppingListDao.findById(id);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body("ShoppingList not found");
        }
        return ResponseEntity.ok(shopList);
    }
    
    /**
     * Return all the shoppinglists of a user
     */
    @GetMapping(value = "/{username}")
    public ResponseEntity getAllShoppingList(@PathVariable String username) {
    	List<ShoppingList> list;
    	User user;
        try {
            user = userDao.findByUsername(username);
            list = shoppingListDao.findByUser(user);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body("ShoppingList not found");
        }
        return ResponseEntity.ok(list);
    }
       
}
