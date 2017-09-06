package org.pomeo44.service;

import org.pomeo44.model.Book;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface BookService {
	List<Book> findAll();
	void saveBook(Book book);
	
	@Cacheable("books")
	Book findOne(long id);
	void delete(long id);
	List<Book> findByName(String name);
	List<Book> findByNameAndAuthor(String name, String author);
	List<Book> findByPrice(long price);
	List<Book> findByPriceRange(long price1, long price2);
	List<Book> findByNameMatch(String name);
	List<Book> findByNamedParam(String name, String author, long price);
}
