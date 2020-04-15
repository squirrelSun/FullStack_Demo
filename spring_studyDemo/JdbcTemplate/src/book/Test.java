package com.book;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.book.controller.BookController;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("book.xml");
		BookController controller = ac.getBean("bookController", BookController.class);
		System.out.println(controller);
		controller.buyBook();
	}
	
}
