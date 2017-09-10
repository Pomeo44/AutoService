package org.pomeo44.service.api.security;

import org.pomeo44.model.security.User;

public interface UserService {

	User findById(int id);
	
	User findBySso(String sso);
	
}