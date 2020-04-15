package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.book.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	public void buyBook() {
		bookService.buyBook(1001, 1);
	};
	
}
