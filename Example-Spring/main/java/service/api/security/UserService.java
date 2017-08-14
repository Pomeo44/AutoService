package service.api.security;

import model.security.User;

public interface UserService {

	User findById(int id);
	
	User findBySso(String sso);
	
}