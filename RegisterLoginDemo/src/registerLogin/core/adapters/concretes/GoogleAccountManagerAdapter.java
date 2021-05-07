package registerLogin.core.adapters.concretes;

import registerLogin.core.adapters.abstracts.AccountService;
import registerLogin.googleAccount.GoogleAccountManager;

public class GoogleAccountManagerAdapter implements AccountService {

	GoogleAccountManager googleAccountManager = new GoogleAccountManager();
	
	@Override
	public void register(String email, String password) {	

		boolean result = googleAccountManager.register(email, password);
		if(result==true) {
			System.out.println("Google Account registration successfull");
		}else {
			System.out.println("Invalid Information please try again");
		}
		
	}

	@Override
	public void login(String email, String password) {

		boolean result = googleAccountManager.login(email, password);
		if(result==true) {
			System.out.println("Google Account registration successfull");
		}else {
			System.out.println("Invalid Google Account!");
		}
	}
 
}
