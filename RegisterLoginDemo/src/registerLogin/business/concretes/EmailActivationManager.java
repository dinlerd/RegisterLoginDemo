package registerLogin.business.concretes;


import registerLogin.business.abstracts.EmailActivationService;
import registerLogin.core.utilities.helpers.EmailSendService;
import registerLogin.entities.concretes.User;

public class EmailActivationManager implements EmailActivationService {

	EmailSendService emailSendService;
	
	public EmailActivationManager(EmailSendService emailSendService) {
		super();
		this.emailSendService = emailSendService;
	}

	@Override
	public boolean emailActivate(User user) {
		emailSendService.emailSend(user.getEmail());
		user.setActivated(true);
		System.out.println("Email validated.");
		return true;
	}
	
}
