package model;

import java.util.List;
import java.util.Queue;

public class CashRegister {
	Queue<Request> requests;
	int waitingTime;
	
	public int estimatedWaitingTime(){
		return this.waitingTime;
	}
	public int proccessRequests(){
		this.processRequest(requests.poll());
//		this.totalTimeProducts(requests.getList());
//		return this.waitingTime;
		return waitingTime;
	}
	
	private void processRequest(Request request){
		
	}
	
}
