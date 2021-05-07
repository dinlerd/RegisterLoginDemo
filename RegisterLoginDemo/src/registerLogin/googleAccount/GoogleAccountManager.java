package registerLogin.googleAccount;

public class GoogleAccountManager {
	public boolean register(String email, String password) {
		boolean result = true;
		System.out.println("Google account registered for " + email);
		return result;
	}
	
	public boolean login(String email, String password) {
		boolean result = true;
		System.out.println("Signed in Google account successfuly for " + email);
		return result;
	}
}
