package grupod.desapp.unq.edu.ar.model.user;

public class Client extends User {
	private boolean firstTime;
	private Profile profile;
	
	public Client(){
		
	}
	
	public Client(String username, String password){
		super(username, password, AccessLevel.CLIENT);
		this.setFirstTime(true);
	}


	public boolean isFirstTime() {
		return firstTime;
	}

	public void setFirstTime(boolean firstTime) {
		this.firstTime = firstTime;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
}