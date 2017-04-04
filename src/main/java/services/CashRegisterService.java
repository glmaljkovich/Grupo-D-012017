package services;

import model.CashRegister;
import model.Request;
import model.ShoppingList;
import model.User;

public class CashRegisterService {
	private CashRegister cashRegister;
	
	public void addRequest(Request request){
		cashRegister.addRequest(request);
	}
	
}
