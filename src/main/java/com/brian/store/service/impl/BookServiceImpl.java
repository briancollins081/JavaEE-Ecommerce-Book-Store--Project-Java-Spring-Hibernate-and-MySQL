package com.brian.store.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.store.domain.Book;
import com.brian.store.service.BookService;
import com.brian.store.service.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> findAll() {
		List<Book> bookList=(List<Book>) bookRepository.findAll();
		List<Book> activeBookList=new ArrayList<>();
		
		for (Book book : bookList) {
			if(book.isActive()) {
				activeBookList.add(book);
			}
		}
		return activeBookList;
	}

	@Override
	public Book findOne(Long id) {

		return bookRepository.findById(id).get();
	}

	@Override
	public List<Book> findByCategory(String category) {
		List<Book> bookList = bookRepository.findByCategory(category);

		List<Book> activeBookList = new ArrayList<Book>();

		for (Book book : bookList) {
			if (book.isActive()) {
				activeBookList.add(book);
			}
		}
		return activeBookList;
	}

	@Override
	public List<Book> findByLanguage(String language) {
		List<Book> bookList = bookRepository.findByLanguage(language);

		List<Book> activeBookList = new ArrayList<Book>();

		for (Book book : bookList) {
			if (book.isActive()) {
				activeBookList.add(book);
			}
		}
		return activeBookList;
	}

	@Override
	public List<Book> blurrySearch(String title) {
		List<Book> bookList = bookRepository.findByTitleContaining(title);

		List<Book> activeBookList = new ArrayList<Book>();

		for (Book book : bookList) {
			if (book.isActive()) {
				activeBookList.add(book);
			}
		}
		return activeBookList;
	}

}
