package grupod.desapp.unq.edu.ar.model.cashregister;

import grupod.desapp.unq.edu.ar.model.requests.Request;

/**
 * Created by gabriel on 11/04/17.
 */
public class ExpressCashRegister extends CashRegister {
    private int productLimit = 10;

    public ExpressCashRegister(){
        super();
    }

    public ExpressCashRegister(int productLimit){
        this.productLimit = productLimit;
    }

    @Override
    public boolean acceptRequest(Request request) {
        return request.getShoppingListSize() <= productLimit;
    }
}
