package registerLogin.core.utilities.helpers;

public class EmailSendManager implements EmailSendService{

	@Override
	public void emailSend(String email) {
		System.out.println("Activation link sent via email to " + email);
		
	}

}
