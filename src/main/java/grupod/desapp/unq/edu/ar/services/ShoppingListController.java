package grupod.desapp.unq.edu.ar.services;

import grupod.desapp.unq.edu.ar.model.shoppinglist.ListItem;
import grupod.desapp.unq.edu.ar.model.shoppinglist.Product;
import grupod.desapp.unq.edu.ar.model.shoppinglist.ShoppingList;
import grupod.desapp.unq.edu.ar.model.user.User;
import grupod.desapp.unq.edu.ar.persistence.ListItemDAO;
import grupod.desapp.unq.edu.ar.persistence.ProductDAO;
import grupod.desapp.unq.edu.ar.persistence.ShoppingListDAO;
import grupod.desapp.unq.edu.ar.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/shoppingList")
public class ShoppingListController {

	@Autowired
    private ShoppingListDAO shoppingListDao;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ListItemDAO listItemDAO;

    @Autowired
    private UserDAO userDao;

    /**
     * Create a new shoppingList and save it in the database.
     */
    @PostMapping(value = "/{username}", headers = "content-type=application/json")
    public ResponseEntity create(@RequestBody ShoppingList shoppingList, @PathVariable String username) {
        ShoppingList result;
        try {
            User user = userDao.findByUsername(username);
            shoppingList.setUser(user);
             result = shoppingListDao.save(shoppingList);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error creating the shoppingList");
        }
        return ResponseEntity.ok(result.getId());
    }

    @PostMapping(value = "/update", headers = "content-type=application/json")
    public ResponseEntity update(@RequestBody ShoppingList shoppingList) {
        try {
            ShoppingList laPosta = shoppingListDao.findById(shoppingList.getId());
            List<ListItem> items = shoppingList.getItems().stream().map(item -> {
                ListItem original = listItemDAO.getById(item.getId());
                original.setQuantity(item.getQuantity());
                listItemDAO.save(original);
                return original;
            }).collect(Collectors.toList());

            laPosta.setItems(items);
            shoppingListDao.save(laPosta);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error creating the shoppingList");
        }
        return ResponseEntity.ok("Cambios guardados");
    }

    /**
     * Create a new shoppingList and save it in the database.
     */
    @PostMapping(value = "/add-item/{id}", headers = "content-type=application/json")
    public ResponseEntity addItem(@RequestBody ListItem item, @PathVariable Integer id) {
        try {
            ShoppingList list = shoppingListDao.findById(id);
            Product product = productDAO.findById(item.getProduct().getId());
            item.setProduct(product);
            listItemDAO.save(item);
            list.addItem(item);
            shoppingListDao.save(list);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok("Item added");
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
