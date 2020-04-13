package spring.userMod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.userMod.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	public void addUser() {
		service.addUser();
	}
	
	public UserController() {
		System.out.println("UserController");
	}
	
}
