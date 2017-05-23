package grupod.desapp.unq.edu.ar.services;

import grupod.desapp.unq.edu.ar.model.cashregister.CashRegister;
import grupod.desapp.unq.edu.ar.model.exceptions.NoCashRegisterAvailableException;
import grupod.desapp.unq.edu.ar.model.requests.Request;
import grupod.desapp.unq.edu.ar.model.requests.RequestManager;
import grupod.desapp.unq.edu.ar.model.user.User;
import grupod.desapp.unq.edu.ar.persistence.CashRegisterDAO;
import grupod.desapp.unq.edu.ar.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gabriel on 23/05/17.
 */
@Service
public class CashRegisterService {
    @Autowired
    private CashRegisterDAO cashRegisterDAO;

    @Autowired
    private UserDAO userDao;

    public CashRegister checkout(Request request) throws NoCashRegisterAvailableException{
        User client = userDao.findByUsername(request.getClient().getUsername());
        request.setClient(client);
        CashRegister register = new RequestManager(cashRegisterDAO.findAll()).getCashRegisterWithLesserWaitingTime(request);
        register.addRequest(request);

        return register;
    }
}
