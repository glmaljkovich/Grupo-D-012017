package model;

import java.util.List;

public class CashRegister {
	List<Request> requests;
	int waitingTime;
	
	public int estimatedWaitingTime(Request request){
		return this.waitingTime;
	}
	
//	public void proccessRequest(Request request){
//		this.totalTimeProducts(request.getList());
//	}
//	public void proccessProduct(Product product){
//		product.getTime();
//	}
	
	
}
