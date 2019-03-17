package com.brian.store.service.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brian.store.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

	List<Book> findByCategory(String category);

	List<Book> findByLanguage(String language);

	List<Book> findByTitleContaining(String title);
	
}
