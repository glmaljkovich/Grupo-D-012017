package grupod.desapp.unq.edu.ar.persistence;

import grupod.desapp.unq.edu.ar.model.cashregister.CashRegister;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by gabriel on 16/05/17.
 */
public interface CashRegisterDAO extends CrudRepository<CashRegister, Integer> {
    public CashRegister findById(int id);

    public List<CashRegister> findAll();
}
