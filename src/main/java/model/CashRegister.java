package model;

import java.util.List;
import java.util.Queue;

public class CashRegister {
	Queue<Request> requests;
	int waitingTime;
	
	public int estimatedWaitingTime(){
		return waitingTime;
	}
	
	private void processRequest(Request request){
		request.getList().forEach(product -> waitingTime -= product.getTime());
	}
	
	public void addRequest(Request request){
		requests.add(request);
		this.increaseWaitingTime(request.getDuration());
		processRequest(requests.poll());
	}
	
	public void increaseWaitingTime(int duration){
		this.waitingTime+=duration;
	}
	
	public void deleteRequest(Request request){
		this.requests.remove(request);
	}
	
	public int totalTimeRequests(){
		this.requests.forEach(request -> waitingTime += request.getDuration());
		return waitingTime;
	}

}
