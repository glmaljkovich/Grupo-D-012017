package model;

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
