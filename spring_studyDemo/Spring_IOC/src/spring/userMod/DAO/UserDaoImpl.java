package spring.userMod.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("UserDaoImpl");
	}

	@Override
	public void addUser() {
		System.out.println("添加成功");
	}
	
}
