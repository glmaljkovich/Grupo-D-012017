package model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RequestManagerTest {

	private CashRegister registerOne;
	private CashRegister registerTwo;
	private CashRegister registerThree;
    private Request requestOne;
    private Request requestTwo;
    private Request requestThree;
    private ArrayList<ListItem> list;
    private ListItem listItem;
    private RequestManager requestManager;
    private ArrayList<CashRegister> listCashRegister;
    private HashMap<Integer,Integer> idTimeLess;
    @Before
    public void setUp() throws Exception {
        registerOne             = new CashRegister();
        registerTwo             = new CashRegister();
        registerThree           = new CashRegister();
        requestOne              = mock(Request.class);
        requestTwo              = mock(Request.class);
        requestThree            = mock(Request.class);
        list                    = new ArrayList<>();
        listCashRegister		= new ArrayList<>();
        listItem                 = mock(ListItem.class);
        registerOne.setExpress(true);
        registerThree.setExpress(true);
        listCashRegister.add(registerOne);
        listCashRegister.add(registerTwo);
        listCashRegister.add(registerThree);
		requestManager = new RequestManager(listCashRegister);
		
        list.add(listItem);

        registerOne.setId(1);
        registerTwo.setId(2);
        registerThree.setId(3);
        when(requestOne.getDuration()).thenReturn(5);
        when(requestTwo.getDuration()).thenReturn(15);
        when(requestThree.getDuration()).thenReturn(9);
        when(listItem.getTime()).thenReturn(1);
    }
    

	
	@Test
	public void totalCashRegisterTest() {
		assertEquals(3, listCashRegister.size());
	}
	
	@Test
	public void getCashRegisterAcceptRequestTest() {
		assertEquals(2,requestManager.getCashRegistersAcceptRequest(this.requestOne).size());
	}
	
	@Test
	public void acceptRequestTest() {
		registerOne.acceptRequest(requestOne);
		assertEquals(true,this.registerOne.acceptRequest(requestOne));
	}
	
	@Test
	public void getCashRegisterTimeLessTest() {
		requestManager.getCashRegistersAcceptRequest(requestOne);
		assertEquals(this.registerOne,this.requestManager.getCashRegisterTimeLess());
	}
}
