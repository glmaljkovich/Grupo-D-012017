package grupod.desapp.unq.edu.ar.services;

import grupod.desapp.unq.edu.ar.model.cashregister.CashRegister;
import grupod.desapp.unq.edu.ar.model.exceptions.NoCashRegisterAvailableException;
import grupod.desapp.unq.edu.ar.model.requests.Request;
import grupod.desapp.unq.edu.ar.model.requests.RequestManager;
import grupod.desapp.unq.edu.ar.model.shoppinglist.ShoppingList;
import grupod.desapp.unq.edu.ar.model.user.User;
import grupod.desapp.unq.edu.ar.persistence.CashRegisterDAO;
import grupod.desapp.unq.edu.ar.persistence.RequestsDAO;
import grupod.desapp.unq.edu.ar.persistence.ShoppingListDAO;
import grupod.desapp.unq.edu.ar.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gabriel on 23/05/17.
 */
@Service
public class CashRegisterService {
    @Autowired
    private CashRegisterDAO cashRegisterDAO;

    @Autowired
    private RequestsDAO requestsDAO;

    @Autowired
    private ShoppingListService shoppingListService;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private ShoppingListDAO shoppingListDao;

    @Transactional
    public CashRegister checkout(Request request) throws NoCashRegisterAvailableException{
        User client = userDao.findByUsername(request.getClient().getUsername());

        request.setClient(client);
        ShoppingList list = shoppingListDao.findById(request.getShoppingList().getId());
        request.setShoppingList(list);
        request.initializeDuration();
        requestsDAO.save(request);

        CashRegister register = new RequestManager(cashRegisterDAO.findAll()).getCashRegisterWithLesserWaitingTime(request);
        register.addRequest(request);

        cashRegisterDAO.save(register);

        Integer id = request.getShoppingList().getId();

        shoppingListService.addToHistory(id);
        shoppingListService.delete(id);

        return register;
    }
}
