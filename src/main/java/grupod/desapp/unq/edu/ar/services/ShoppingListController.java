package grupod.desapp.unq.edu.ar.services;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.ArrayList;
import java.util.stream.Collectors;

import grupod.desapp.unq.edu.ar.model.shoppinglist.ShoppingList;
import grupod.desapp.unq.edu.ar.model.user.User;
import grupod.desapp.unq.edu.ar.persistence.ShoppingListDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import antlr.collections.List;


@Controller
@RequestMapping("/shoppingList")
public class ShoppingListController {

	@Autowired
    private ShoppingListDAO shoppingListDao;


    /**
     * GET /create  --> Create a new shoppingList and save it in the database.
     */
    @RequestMapping(method = POST, headers = "content-type=application/json")
    @ResponseBody
    public String create(@RequestBody ShoppingList shoppingList) {
        String shoppingListId = "";
        try {
            shoppingListDao.save(shoppingList);
            shoppingListId = String.valueOf(shoppingList.getId());
        }
        catch (Exception ex) {
            return "Error creating the shoppingList: " + ex.toString();
        }
        return "ShoppingList succesfully created with id = " + shoppingListId;
    }

    /**
     * GET /delete  --> Delete the shoppingList having the passed id.
     */
    @RequestMapping(method = DELETE, headers = "content-type=application/json")
    @ResponseBody
    public String delete(int id) {
        try {
            ShoppingList shoppingList = shoppingListDao.findById(id);
            shoppingListDao.delete(shoppingList);
        }
        catch (Exception ex) {
            return "Error deleting the shoppingList: it doesn't exist";
        }
        return "ShoppingList succesfully deleted!";
    }
    
    /**
     * GET /get-by-email  --> Return the id for the user having the passed
     * email.
     */
    @RequestMapping(value = "/get-shoppingList", method = GET)
    @ResponseBody
    public String getById(int id) {
        String shopListId = "";
        try {
            ShoppingList shopList = shoppingListDao.findById(id);
            shopListId = String.valueOf(shopList.getId());
        }
        catch (Exception ex) {
            return "ShoppingList not found";
        }
        return "The shoppingList id is: " + shopListId;
    }
    
    /**
     * GET /  --> Return the id for the user having the passed
     * email.
     */
    @RequestMapping(value = "/get-all-shoppingList", method = GET)
    @ResponseBody
    public String getAllShoppingList() {
    	ArrayList<String> list = new ArrayList<String>();
    	String result = "";
        try {
            Iterable<ShoppingList> shopList = shoppingListDao.findAll();
            shopList.forEach(each -> list.add(String.valueOf(each.getId())));
            result = list
                    .stream()
                    .map(s -> s.substring(0, 1))
                    .collect(Collectors.joining());
        }
        catch (Exception ex) {
            return "ShoppingList not found";
        }
        return "The shoppingList id is: " + result;
    }
   
    /**
     * GET /update  --> Update the email and the name for the user in the
     * database having the passed id.
     */
//    @RequestMapping(method = PUT, headers = "content-type=application/json")
//    @ResponseBody
//    public String updateShoppingList(@RequestBody ShoppingList updated) {
//        try {
//            ShoppingList user = shoppingListDao.findOne(updated.getId());
//            shoppingListDao.set(updated.getListItem());
//            shoppingListDao.save(shoppingListDao);
//        }
//        catch (Exception ex) {
//            return "Error updating the shoppingList: " + ex.toString();
//        }
//        return "ShoppingList succesfully updated!";
//    }
    
}
