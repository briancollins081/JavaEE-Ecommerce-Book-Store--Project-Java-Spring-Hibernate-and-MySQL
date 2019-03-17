package com.brian.store.service;

import java.util.List;

import com.brian.store.domain.Book;

public interface BookService {
	List<Book> findAll();

	Book findOne(Long id);

	List<Book> findByCategory(String category);

	List<Book> findByLanguage(String language);

	List<Book> blurrySearch(String keyword);
}
