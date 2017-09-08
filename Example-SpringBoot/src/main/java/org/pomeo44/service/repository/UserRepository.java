package org.pomeo44.service.repository;

import org.pomeo44.model.security.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findBySSO(String sso);
}

