package registerLogin.business.abstracts;

import registerLogin.entities.concretes.User;

public interface EmailActivationService {
	boolean emailActivate(User user);
}
