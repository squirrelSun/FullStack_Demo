package spring.userMod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.userMod.DAO.UserDao;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("UserServiceImpl");
	}

	@Override
	public void addUser() {
		userDao.addUser();
	}
	
}
