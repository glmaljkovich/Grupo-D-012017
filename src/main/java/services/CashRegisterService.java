package services;

import model.CashRegister;
import model.Request;

public class CashRegisterService {
	private CashRegister cashRegister;
	
	public void addRequest(Request request){
		cashRegister.addRequest(request);
	}
	
}
