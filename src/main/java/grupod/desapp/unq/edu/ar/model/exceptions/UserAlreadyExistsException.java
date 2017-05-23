package grupod.desapp.unq.edu.ar.model.exceptions;

/**
 * Created by gabriel on 23/05/17.
 */
public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(){
        super("Usuario existente.");
    }
}
