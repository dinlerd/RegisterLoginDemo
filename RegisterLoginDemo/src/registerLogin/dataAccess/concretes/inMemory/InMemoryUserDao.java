package registerLogin.dataAccess.concretes.inMemory;

import java.util.List;

import registerLogin.dataAccess.abstracts.UserDao;
import registerLogin.entities.concretes.User;

public class InMemoryUserDao implements UserDao {

	List<User> users;
	
	public InMemoryUserDao(List<User> users) {
		super();
		this.users = users;
	}

	@Override
	public void add(User user) {
		this.users.add(user);
		
	}

	@Override
	public void update(User user) {
		User userToUpdate = this.users.stream().filter(u -> u.getId() == user.getId()).findFirst().orElse(null);
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setPassword(user.getPassword());
	}

	@Override
	public void delete(User user) {
		this.users.removeIf(u -> u.getId() == user.getId());
	}

	@Override
	public User get(int id) {
		User user = this.users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
		return user;
	}

	@Override
	public List<User> getAll() {
		
		return this.users;
	}

	@Override
	public User getByEmail(String email) {
		User user = this.users.stream().filter(u -> u.getEmail() == email).findFirst().orElse(null);
		return user;
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		User user = this.users.stream().filter(u -> u.getEmail() == email && u.getPassword() == password).findFirst().orElse(null);
		return user;
	}

}
