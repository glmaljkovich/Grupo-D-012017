package model;

public class Alert {
	private boolean enabled;
	private String message;

	public Alert(){
		this.message = "";
	}

	public Alert(String message){
		this.message = message;
	}

	public String getMessage(){return this.message;}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
