package org.pomeo44.service.impl;

import org.pomeo44.service.repository.UserRepository;
import org.pomeo44.model.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.pomeo44.service.api.security.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public User findById(int id) {
		return userRepository.findOne(id);
	}

	public User findBySso(String sso) {
		return userRepository.findBySSO(sso);
	}

}
