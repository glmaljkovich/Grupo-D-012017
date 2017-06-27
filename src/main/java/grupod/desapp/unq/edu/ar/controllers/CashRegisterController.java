package grupod.desapp.unq.edu.ar.controllers;

import grupod.desapp.unq.edu.ar.model.cashregister.CashRegister;
import grupod.desapp.unq.edu.ar.model.exceptions.NoCashRegisterAvailableException;
import grupod.desapp.unq.edu.ar.model.requests.Request;
import grupod.desapp.unq.edu.ar.services.CashRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gabriel on 16/05/17.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/checkout")
public class CashRegisterController {

    @Autowired
    private CashRegisterService cashRegisterService;

    /**
     * Return a cash register id and waiting time.
     */
    @PostMapping
    public ResponseEntity<CashRegister> checkout(@RequestBody Request request) {
        CashRegister register;
        try {
            register = cashRegisterService.checkout(request);
        } catch (NoCashRegisterAvailableException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(register);
    }
}
