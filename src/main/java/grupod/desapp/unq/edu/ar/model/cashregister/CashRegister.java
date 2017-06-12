package grupod.desapp.unq.edu.ar.model.cashregister;

import com.fasterxml.jackson.annotation.JsonProperty;
import grupod.desapp.unq.edu.ar.model.requests.Request;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Entity
@Table(name = "registers")
public class CashRegister implements Serializable{
	@JsonProperty(access = WRITE_ONLY)
	@Column
	@ElementCollection(targetClass=Request.class)
	private List<Request> requests;
	private int waitingTime;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public CashRegister() {
		this.waitingTime 	= 0;
		this.requests 		= new LinkedList<>();
	}

	public boolean acceptRequest(Request request){
		return true;
	}

	public void processNextRequest(){
		Request nextRequest = ((LinkedList<Request>) requests).poll();
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
		this.waitingTime = this.waitingTime - duration;
	}

	private void increaseWaitingTime(int duration){
		this.waitingTime = this.waitingTime + duration;
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
