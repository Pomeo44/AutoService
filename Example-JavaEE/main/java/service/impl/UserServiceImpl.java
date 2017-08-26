package service.impl;

import model.security.User;
import service.api.security.UserService;

public class UserServiceImpl implements UserService {
	@Override
	public User findById(int id) {
		return null;
	}

	@Override
	public User findBySso(String sso) {
		return null;
	}

//	public User findById(int id) {
//		return userDao.findById(id);
//	}
//
//	public User findBySso(String sso) {
//		return userDao.findBySSO(sso);
//	}

}
