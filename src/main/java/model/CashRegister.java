package model;

import java.util.LinkedList;
import java.util.Queue;

public class CashRegister {
	private Queue<Request> requests;
	private int waitingTime;
	private int id;
	private boolean express;

	public CashRegister() {
		this.waitingTime 	= 0;
		this.requests 		= new LinkedList<>();
		this.express = false;
	}
	
	public boolean isExpress() {
		return this.express;
	}

	public boolean acceptRequest(Request request){
		return (this.isExpress() && request.getSizeShoppingList() < 10) || ((!this.isExpress()) && request.getSizeShoppingList() > 10);
	}
	public void setExpress(boolean express) {
		this.express = express;
	}

	public void processNextRequest(){
		Request nextRequest = requests.poll();
		nextRequest.getList().forEach(product -> this.decreaseWaitingTime(product.getTime()));
	}
	
	public void addRequest(Request request){
		requests.add(request);
		this.increaseWaitingTime(request.getDuration());
	}

	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}

	private void decreaseWaitingTime(int duration){
		this.waitingTime -= duration;
	}

	private void increaseWaitingTime(int duration){
		this.waitingTime+=duration;
	}
	
	public void removeRequest(Request request){
		this.requests.remove(request);
		this.decreaseWaitingTime(request.getDuration());
	}
	
	public int getWaitingTime(){
		return waitingTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
