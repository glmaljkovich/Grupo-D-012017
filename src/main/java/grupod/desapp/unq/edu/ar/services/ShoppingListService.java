package grupod.desapp.unq.edu.ar.services;

import grupod.desapp.unq.edu.ar.model.exceptions.ItemAlreadyExistsException;
import grupod.desapp.unq.edu.ar.model.shoppinglist.ListItem;
import grupod.desapp.unq.edu.ar.model.shoppinglist.Product;
import grupod.desapp.unq.edu.ar.model.shoppinglist.ShoppingList;
import grupod.desapp.unq.edu.ar.model.user.User;
import grupod.desapp.unq.edu.ar.persistence.ListItemDAO;
import grupod.desapp.unq.edu.ar.persistence.ProductDAO;
import grupod.desapp.unq.edu.ar.persistence.ShoppingListDAO;
import grupod.desapp.unq.edu.ar.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gabriel on 23/05/17.
 */
@Service
public class ShoppingListService {

    @Autowired
    private ShoppingListDAO shoppingListDao;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ListItemDAO listItemDAO;

    @Autowired
    private UserDAO userDao;

    public void addItem(Integer id, ListItem item) throws ItemAlreadyExistsException {
        ShoppingList list = shoppingListDao.findById(id);
        Product product = productDAO.findById(item.getProduct().getId());
        item.setProduct(product);
        listItemDAO.save(item);
        list.addItem(item);
        shoppingListDao.save(list);
    }

    public void update(ShoppingList shoppingList){
        ShoppingList laPosta = shoppingListDao.findById(shoppingList.getId());
        List<ListItem> items = shoppingList.getItems().stream().map(item -> {
            if(listItemDAO.getById(item.getId()) != null){
                ListItem original = listItemDAO.getById(item.getId());
                original.setQuantity(item.getQuantity());
                listItemDAO.save(original);
                return original;
            }
            return listItemDAO.save(item);
        }).collect(Collectors.toList());

        laPosta.setItems(items);
        shoppingListDao.save(laPosta);
    }

    public ShoppingList create(ShoppingList shoppingList, String username){
        User user = userDao.findByUsername(username);
        shoppingList.setUser(user);
        return shoppingListDao.save(shoppingList);
    }

    public void delete(Integer id){
        ShoppingList shoppingList = shoppingListDao.findById(id);
        shoppingListDao.delete(shoppingList);
    }

    public ShoppingList findById(Integer id){
        return  shoppingListDao.findById(id);
    }

    public List<ShoppingList> getShoppingListsForUser(String username){
        User user = userDao.findByUsername(username);
        return shoppingListDao.findByUser(user);
    }
}
