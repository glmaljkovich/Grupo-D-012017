package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestManager {

	private List<CashRegister> listCashRegister;
	private List<CashRegister> listCashRegisterAcceptRequest;
	private CashRegister cashRegister;
	
	RequestManager(List<CashRegister> listCashRegister){
		this.listCashRegister = listCashRegister;
	}
	
	public CashRegister getCashRegisterTimeLess(){
		this.cashRegister = this.listCashRegisterAcceptRequest.get(0);
		for(int i = 0; i < this.listCashRegisterAcceptRequest.size(); i++){
			if(this.cashRegister.getWaitingTime() > this.listCashRegisterAcceptRequest.get(i).getWaitingTime()){
				this.cashRegister = this.listCashRegisterAcceptRequest.get(i);
			}
		}
		return this.cashRegister;
	}

	public List<CashRegister> getCashRegistersAcceptRequest(Request request){
		listCashRegisterAcceptRequest = new ArrayList<>();
		for(int i = 0; i < this.listCashRegister.size(); i++){
			if(this.listCashRegister.get(i).acceptRequest(request)){
				listCashRegisterAcceptRequest.add(this.listCashRegister.get(i));
			}
		}
		return listCashRegisterAcceptRequest;
	}
}
