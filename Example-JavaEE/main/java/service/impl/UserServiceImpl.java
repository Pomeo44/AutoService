package service.impl;

import dao.api.UserDao;
import model.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.api.security.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User findById(int id) {
		return userDao.findById(id);
	}

	public User findBySso(String sso) {
		return userDao.findBySSO(sso);
	}

}
