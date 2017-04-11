package model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by gabriel on 11/04/17.
 */
public class RequestManagerTest {
    private CashRegister register;
    private RequestManager manager;
    private Request request;
    private List<CashRegister> list;

    @Before
    public void setUp() throws Exception {
        register    = mock(CashRegister.class);
        list        = new ArrayList<>();
        manager     = new RequestManager(list);
        request     = mock(Request.class);
        list.add(register);

    }

    @Test(expected = NoCashRegisterAvailableException.class)
    public void getCashRegisterReturnsThrowsExceptionIfThereAreNoRegistersAcceptingThatRequest() throws NoCashRegisterAvailableException {
        when(register.acceptRequest(request)).thenReturn(false);

        manager.getCashRegisterWithLesserWaitingTime(request);
    }

    @Test
    public void getCashRegisterWithLesserWaitingTimeExcludesTheExpressOne() throws Exception {
        ExpressCashRegister expressRegister = mock(ExpressCashRegister.class);
        list.add(expressRegister);

        when(register.acceptRequest(request)).thenReturn(true);
        when(expressRegister.acceptRequest(request)).thenReturn(false);
        when(register.getWaitingTime()).thenReturn(10);

        assertEquals(register, manager.getCashRegisterWithLesserWaitingTime(request));
    }

    @Test
    public void getCashRegisterWithLesserWaitingTime() throws Exception {
        CashRegister register2 = mock(CashRegister.class);
        list.add(register2);

        when(register.acceptRequest(request)).thenReturn(true);
        when(register2.acceptRequest(request)).thenReturn(true);
        when(register.getWaitingTime()).thenReturn(10);
        when(register.getWaitingTime()).thenReturn(5);

        assertEquals(register2, manager.getCashRegisterWithLesserWaitingTime(request));
    }

    @Test
    public void setCashRegisterList() throws Exception {
        List<CashRegister> list2 = new ArrayList<>();

        manager.setCashRegisterList(list2);

        assertEquals(list2, manager.getCashRegisterList());
    }

}