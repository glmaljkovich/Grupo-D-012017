package model.cashregister;

import model.requests.Request;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by gabriel on 11/04/17.
 */
public class ExpressCashRegisterTest {
    private ExpressCashRegister register;
    private Request request;

    @Test
    public void acceptRequestIsFalseForARequestWith1ItemMoreThanTheLimit() throws Exception {
        register    = new ExpressCashRegister(8);
        request     = mock(Request.class);

        when(request.getShoppingListSize()).thenReturn(9);

        assertFalse(register.acceptRequest(request));
    }

    @Test
    public void acceptRequestIsTrueForARequestWithTheExactLimit() throws Exception {
        register    = new ExpressCashRegister();
        request     = mock(Request.class);

        when(request.getShoppingListSize()).thenReturn(10);

        assertTrue(register.acceptRequest(request));
    }

}