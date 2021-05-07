package registerLogin.business.concretes;

import java.util.List;

import registerLogin.business.abstracts.UserService;
import registerLogin.dataAccess.abstracts.UserDao;
import registerLogin.entities.concretes.User;

public class UserManager implements UserService {

	UserDao userDao;
	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		userDao.add(user);
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public User getByEmail(String email) {

		return userDao.getByEmail(email);
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {

		return userDao.getByEmailAndPassword(email, password);
	}

}
