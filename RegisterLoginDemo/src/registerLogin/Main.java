package registerLogin;

import java.util.ArrayList;

import registerLogin.business.abstracts.AuthService;
import registerLogin.business.abstracts.UserService;
import registerLogin.business.concretes.AuthManager;
import registerLogin.business.concretes.EmailActivationManager;
import registerLogin.business.concretes.UserManager;
import registerLogin.core.adapters.abstracts.AccountService;
import registerLogin.core.adapters.concretes.GoogleAccountManagerAdapter;
import registerLogin.core.utilities.helpers.EmailSendManager;
import registerLogin.dataAccess.concretes.inMemory.InMemoryUserDao;
import registerLogin.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1 = new User(1,"firstname1","lastname1","firstname1@firstname1.com","123450");
		User user2 = new User(1,"firstname2","lastname2","firstname2@firstname2.com","23456"); //password < 6 characters
		User user3 = new User(1,"firstname3","lastname3","firstname3firstname3.com","345670"); //email wrong
		User user4 = new User(1,"firstname4","lastname4","firstname4@firstname4.com","456780");

		UserService userManager = new UserManager(new InMemoryUserDao(new ArrayList<User>()));
		
		AuthService authManager = new AuthManager(userManager, new EmailActivationManager(new EmailSendManager()) );
		System.out.println("--------------");
		authManager.register(user1);
		System.out.println("--------------");
		authManager.register(user2);
		System.out.println("--------------");
		authManager.register(user3);
		System.out.println("--------------");
		authManager.register(user4);
		System.out.println("--------------");

		
		
		authManager.login(user4);
		System.out.println("--------------");
		authManager.login(user1);
		System.out.println("--------------");
		authManager.login(user2); //Unsuccessful login
		System.out.println("--------------");
		authManager.login(user3); //Unsuccessful login
		System.out.println("--------------");
		
		AccountService accountService = new GoogleAccountManagerAdapter();
		accountService.register("name@google.com", "111111");
		
		
	}

}
