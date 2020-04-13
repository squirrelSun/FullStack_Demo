package spring.userMod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.userMod.DAO.UserDao;
import spring.userMod.DAO.UserDaoImpl;
import spring.userMod.controller.UserController;
import spring.userMod.service.UserService;
import spring.userMod.service.UserServiceImpl;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("user.xml");
		
		UserController userController = ac.getBean("userController", UserController.class);
		System.out.println(userController);
		UserDao userDaoImpl = ac.getBean("userDaoImpl", UserDaoImpl.class);
		System.out.println(userDaoImpl);
		UserService userServiceImpl = ac.getBean("userServiceImpl", UserServiceImpl.class);
		System.out.println(userServiceImpl);
		
		userServiceImpl.addUser();
	}
	
}
