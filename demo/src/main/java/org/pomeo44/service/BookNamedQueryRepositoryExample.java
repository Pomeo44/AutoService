package org.pomeo44.service;

import org.pomeo44.model.Book;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BookNamedQueryRepositoryExample extends Repository<Book, Long> {
	// Query will be used from Named query defined at Entity class
	List<Book> findByPrice(long price);
}
