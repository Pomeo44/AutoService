package service.api.security;

import model.security.User;

import javax.ejb.Local;

@Local
public interface UserService {

	User findById(int id);
	
	User findBySso(String sso);
	
}