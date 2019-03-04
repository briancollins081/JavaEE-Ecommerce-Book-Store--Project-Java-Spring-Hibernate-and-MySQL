package com.brian.store.service.repository;



import org.springframework.data.repository.CrudRepository;

import com.brian.store.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	
}
