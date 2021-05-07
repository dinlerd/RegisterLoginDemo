package registerLogin.dataAccess.abstracts;

import java.util.List;

import registerLogin.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(User user);
	User get(int id);
	User getByEmail(String email);
	User getByEmailAndPassword(String email, String password);
	List<User> getAll();
}
