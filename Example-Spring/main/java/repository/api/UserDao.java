package repository.api;

import model.security.User;

public interface UserDao extends Dao<User> {
	User findBySSO(String sso);
}

