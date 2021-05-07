package registerLogin.core.adapters.abstracts;

public interface AccountService {
	void register(String email, String password );
	void login(String email, String password);
	
}
