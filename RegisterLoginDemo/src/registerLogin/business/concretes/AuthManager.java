package registerLogin.business.concretes;

import registerLogin.business.abstracts.AuthService;
import registerLogin.business.abstracts.EmailActivationService;
import registerLogin.business.abstracts.UserService;
import registerLogin.core.utilities.Validator.EmailValidator;
import registerLogin.core.utilities.business.BusinessRules;
import registerLogin.entities.concretes.User;

public class AuthManager implements AuthService {

	UserService userService;
	EmailActivationService emailActivationService;
	
	public AuthManager(UserService userService, EmailActivationService emailActivationService) {
		super();
		this.userService = userService;
		this.emailActivationService = emailActivationService;
	}

	@Override
	public void register(User user) {
			
		boolean result = BusinessRules.run(
				userExists(user.getEmail()), 
				checkPassword(user.getPassword()), 
				checkFields(user),
				checkLength(user.getFirstName(), user.getLastName()));

		if(result) {
			System.out.println("Business rules are valid");
			if(EmailValidator.emailValidate(user.getEmail()) && emailActivationService.emailActivate(user)) {

				userService.add(user);
				System.out.println(user.getFirstName() + " registered!");
				
			}else {

				System.out.println("Account cannot be activated please try to register again!");
			}
		}else {
			System.out.println("Please try again!");
		}

	}

	@Override
	public void login(User user) {
		boolean result = BusinessRules.run(
				userExists(user.getEmail()), 
				checkFields(user), 
				checkPassword(user.getPassword()), 
				checkIfActivated(user));
		User userToCheck = userService.getByEmailAndPassword(user.getEmail(), user.getPassword());
		
		if(result) {
			System.out.println("Business rules are valid");

			if(userToCheck != null) {
				System.out.println("Logged in successfuly!");

			}else {

				System.out.println("Invalid email or password!");
			}
		}else {
			System.out.println("Please try again!");
		}



	}

	@Override
	public boolean userExists(String email) {
		
		if(userService.getByEmail(email) != null) {
			System.out.println("User already exists!");
			return false;
		}
		
		return true;
	}
	
	private boolean checkPassword(String password) {
		if(password.length() >= 6) {
			return true;
		}else {
			System.out.println("Password must be minimum 6 characters!");
			return false;
		}
	}
	
    public boolean checkLength(String firstName, String lastName) {
        if (firstName.length() < 2 && lastName.length() < 2) {
            System.out.println("First or Last Name must be  characters at least");
            return false;
        }
        
        return true;

    }
    
	private boolean checkFields(User user) {
		if( !user.getFirstName().isEmpty() && 
				!user.getLastName().isEmpty() && 
				!user.getEmail().isEmpty() && 
				!user.getPassword().isEmpty()) {
			return true;
		}
		System.out.println("Please fill all fields!");
		return false;
	}
	
	private boolean checkIfActivated(User user) {
		if(user.isActivated()) {
			return true;
		}
		System.out.println("User is not activated yet!");
		return false;
	}

}
