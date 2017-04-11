package model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by gabriel on 09/04/17.
 */
public class CashRegisterTest {
    private CashRegister register;
    private Request request;
    private ArrayList<ListItem> list;
    private ListItem product;

    @Before
    public void setUp() throws Exception {
        register                = new CashRegister();
        request                 = mock(Request.class);
        list                    = new ArrayList<>();
        product                 = mock(ListItem.class);

        list.add(product);

        when(request.getDuration()).thenReturn(10);
        when(product.getTime()).thenReturn(10);
    }

    @Test
    public void addRequest() throws Exception {
        register.addRequest(request);

        assertEquals(register.getWaitingTime(), request.getDuration());
    }

    @Test
    public void acceptRequest() throws Exception {
        assertTrue(register.acceptRequest(request));
    }

    @Test
    public void setWaitingTime() throws Exception {
        int waitingTime = 20;
        register.setWaitingTime(waitingTime);

        assertEquals(waitingTime, register.getWaitingTime());
    }

    @Test
    public void removeRequest() throws Exception {
        register.addRequest(request);

        register.removeRequest(request);

        assertEquals(0, register.getWaitingTime());
    }

    @Test
    public void processNextRequest() throws Exception {
        when(request.getList()).thenReturn(list);

        register.addRequest(request);
        register.processNextRequest();

        assertEquals(0, register.getWaitingTime());
    }

    @Test
    public void setId() throws Exception {
        register.setId(1);

        assertEquals(1, register.getId());
    }
}