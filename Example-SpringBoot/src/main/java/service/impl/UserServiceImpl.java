package service.impl;

import repository.api.UserRepository;
import model.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.api.security.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public User findById(int id) {
		return userRepository.findById(id).get();
	}

	public User findBySso(String sso) {
		return userRepository.findBySSO(sso);
	}

}
