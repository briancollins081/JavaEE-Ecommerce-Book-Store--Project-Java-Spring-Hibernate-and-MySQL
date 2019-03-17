package com.brian.store.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brian.store.domain.Book;
import com.brian.store.domain.User;
import com.brian.store.service.BookService;
import com.brian.store.service.UserService;

@Controller
public class SearchController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;

	@RequestMapping("/searchByCategory")
	public String searchByCategory(@RequestParam("category") String category,
			Model model, Principal principal) {
		if(principal!=null) {
			String username=principal.getName();
			User user=userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		String classActiveCategory="active"+category;
		classActiveCategory=classActiveCategory.replace("\\s+", "");
		classActiveCategory=classActiveCategory.replace("&", "");
		model.addAttribute(classActiveCategory, true);
		
		List<Book> bookList=bookService.findByCategory(category);
		
		if (bookList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "bookshelf";
		}
		model.addAttribute("bookList", bookList);
		
		return "bookshelf";
	}
	
	@RequestMapping("/searchByLanguage")
	public String searchByLanguage(@RequestParam("language") String language,
			Model model, Principal principal) {
		if(principal!=null) {
			String username=principal.getName();
			User user=userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		String classActiveLanguage="active"+language;
		classActiveLanguage=classActiveLanguage.replace("\\s+", "");
		classActiveLanguage=classActiveLanguage.replace("&", "");
		model.addAttribute(classActiveLanguage, true);
		
		List<Book> bookList=bookService.findByLanguage(language);
		
		if (bookList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "bookshelf";
		}
		model.addAttribute("bookList", bookList);
		
		return "bookshelf";
	}
}
