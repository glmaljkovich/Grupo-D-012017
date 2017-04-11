package model.requests;

import model.cashregister.CashRegister;
import model.exceptions.NoCashRegisterAvailableException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RequestManager {

	private List<CashRegister> cashRegisterList;
	
	public RequestManager(List<CashRegister> cashRegisterList){
		this.cashRegisterList = cashRegisterList;
	}
	
	public CashRegister getCashRegisterWithLesserWaitingTime(Request request) throws NoCashRegisterAvailableException {
		Optional<CashRegister> result = this.getCashRegistersForRequest(request)
											.stream()
											.reduce(this::compareCashRegistersByWaitingTime);
		if(! result.isPresent()){
			throw new NoCashRegisterAvailableException();
		}

		return result.get();
	}

	private CashRegister compareCashRegistersByWaitingTime(CashRegister cashRegister1, CashRegister cashRegister2) {
		if(cashRegister1.getWaitingTime() < cashRegister2.getWaitingTime()){
            return cashRegister1;
        }else{
            return cashRegister2;
        }
	}

	private List<CashRegister> getCashRegistersForRequest(Request request){
		return this.cashRegisterList.stream()
							 		.filter(cashRegister -> cashRegister.acceptRequest(request))
							 		.collect(Collectors.toList());
	}

	public List<CashRegister> getCashRegisterList() {
		return cashRegisterList;
	}

	public void setCashRegisterList(List<CashRegister> cashRegisterList) {
		this.cashRegisterList = cashRegisterList;
	}
}
