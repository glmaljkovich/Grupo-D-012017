package model;

public class Alert {
	private boolean enabled;
	//Will have a strategy
	public String getMessage(){return "";}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
