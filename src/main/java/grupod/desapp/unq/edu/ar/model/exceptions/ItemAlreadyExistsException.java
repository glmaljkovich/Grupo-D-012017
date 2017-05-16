package grupod.desapp.unq.edu.ar.model.exceptions;

/**
 * Created by gabriel on 15/05/17.
 */
public class ItemAlreadyExistsException extends Exception {
    public ItemAlreadyExistsException(){
        super("Item already exists. Try changing the quantity instead");
    }
}
