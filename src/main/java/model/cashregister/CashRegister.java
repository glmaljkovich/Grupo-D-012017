package model.cashregister;

import model.requests.Request;

import java.util.LinkedList;
import java.util.Queue;

public class CashRegister {
	private Queue<Request> requests;
	private int waitingTime;
	private int id;

	public CashRegister() {
		this.waitingTime 	= 0;
		this.requests 		= new LinkedList<>();
	}

	public boolean acceptRequest(Request request){
		return true;
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
