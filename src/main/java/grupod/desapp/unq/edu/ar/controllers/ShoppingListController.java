package grupod.desapp.unq.edu.ar.controllers;

import grupod.desapp.unq.edu.ar.model.exceptions.ItemAlreadyExistsException;
import grupod.desapp.unq.edu.ar.model.shoppinglist.ListItem;
import grupod.desapp.unq.edu.ar.model.shoppinglist.Product;
import grupod.desapp.unq.edu.ar.model.shoppinglist.ShoppingList;
import grupod.desapp.unq.edu.ar.services.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/shoppingList")
public class ShoppingListController {

	@Autowired
    private ShoppingListService shoppingListService;

    /**
     * Create a new shoppingList and save it in the database.
     */
    @PostMapping(value = "/{username}", headers = "content-type=application/json")
    public ResponseEntity create(@RequestBody @Validated ShoppingList shoppingList, @PathVariable String username) {
        ShoppingList result;
        try {
            result = shoppingListService.create(shoppingList, username);
        }
        catch (NullPointerException ex) {
            return ResponseEntity.badRequest().body("Error creating the shoppingList");
        }
        return ResponseEntity.ok(result.getId());
    }

    @PostMapping(value = "/update", headers = "content-type=application/json")
    public ResponseEntity update(@RequestBody ShoppingList shoppingList) {
        try {
            shoppingListService.update(shoppingList);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body("Error creating the shoppingList");
        }
        return ResponseEntity.ok("Cambios guardados");
    }

    /**
     * Add an item if it isn't already in the list
     */
    @PostMapping(value = "/add-item/{id}", headers = "content-type=application/json")
    public ResponseEntity addItem(@RequestBody ListItem item, @PathVariable Integer id) {
        try {
            shoppingListService.addItem(id, item);
        }
        catch (ItemAlreadyExistsException ex) {
            return ResponseEntity.badRequest().body("Item already exists. Try changing the quantity instead");
        }
        return ResponseEntity.ok("Item added");
    }

    /**
     * Delete the shoppingList having the passed id.
     */
    @DeleteMapping(value = "/delete/{id}", headers = "content-type=application/json")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            shoppingListService.delete(id);
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
            shopList = shoppingListService.findById(id);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body("ShoppingList not found");
        }
        return ResponseEntity.ok(shopList);
    }

    /**
     * Return a shoppinglist
     */
    @GetMapping("/recommended/{id}")
    public ResponseEntity getRecommendedProducts(@PathVariable int id) {
        List<Product> products;
        try {
            products = shoppingListService.getRecommendedProducts(id);
        }
        catch (Exception ex) {
            return ResponseEntity.ok(new ArrayList<>());
        }
        return ResponseEntity.ok(products);
    }
    
    /**
     * Return all the shoppinglists of a user
     */
    @GetMapping(value = "/{username}")
    public ResponseEntity getAllShoppingList(@PathVariable String username) {
    	List<ShoppingList> list;
        try {
            list = shoppingListService.getShoppingListsForUser(username);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body("ShoppingList not found");
        }
        return ResponseEntity.ok(list);
    }
       
}
