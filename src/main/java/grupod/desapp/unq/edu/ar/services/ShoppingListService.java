package grupod.desapp.unq.edu.ar.services;

import grupod.desapp.unq.edu.ar.model.exceptions.ItemAlreadyExistsException;
import grupod.desapp.unq.edu.ar.model.shoppinglist.*;
import grupod.desapp.unq.edu.ar.model.user.User;
import grupod.desapp.unq.edu.ar.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private ArchivedShoppingListDAO archivedShoppingListDAO;

    @Autowired
    private ArchivedListItemDAO archivedListItemDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ListItemDAO listItemDAO;

    @Autowired
    private UserDAO userDao;

    @Transactional
    public void addItem(Integer id, ListItem item) throws ItemAlreadyExistsException {
        ShoppingList list = shoppingListDao.findById(id);
        Product product = productDAO.findById(item.getProduct().getId());
        item.setProduct(product);
        listItemDAO.save(item);
        list.addItem(item);
        shoppingListDao.save(list);
    }

    @Transactional
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

    @Transactional
    public ShoppingList create(ShoppingList shoppingList, String username){
        User user = userDao.findByUsername(username);
        shoppingList.setUser(user);
        return shoppingListDao.save(shoppingList);
    }

    @Transactional
    public void delete(Integer id){
        ShoppingList shoppingList = shoppingListDao.findById(id);
        shoppingListDao.delete(shoppingList);
    }

    @Transactional
    public ShoppingList findById(Integer id){
        return  shoppingListDao.findById(id);
    }

    @Transactional
    public List<ShoppingList> getShoppingListsForUser(String username){
        User user = userDao.findByUsername(username);
        return shoppingListDao.findByUser(user);
    }

    @Transactional
    public Page<ArchivedShoppingList> getHistoryForUser(String username, Pageable pageable) {
        return archivedShoppingListDAO.findByUsername(username, pageable);
    }

    @Transactional
    public void addToHistory(Integer id) {
        ShoppingList list               = shoppingListDao.findById(id);
        ArchivedShoppingList serialized = ShoppingListTransformer.serialize(list);
        serialized.getItems().forEach(archivedListItem -> archivedListItemDAO.save(archivedListItem));
        archivedShoppingListDAO.save(serialized);
    }

    @Transactional
    public ShoppingList copy(Integer id) {
        ArchivedShoppingList list = archivedShoppingListDAO.findById(id);
        return ShoppingListTransformer.deserialize(list, this);
    }
}
