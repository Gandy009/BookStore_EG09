package com.bookstore.service.impl;

import com.bookstore.bean.User;
import com.bookstore.dao.UserDao;
import com.bookstore.dao.impl.UserDaoImpl;
import com.bookstore.service.UserService;
/**
 * UserService的实现类
 * @author syd
 *
 */
public class UserServiceImpl implements UserService {
	//创建一个UserDao
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User login(User user) {
		
		return userDao.getUserByUsernameAndPassword(user);
	}

	@Override
	public boolean regist(User user) {
		int count =userDao.savaUser(user);
		return count ==1;
	}

	@Override
	public boolean checkUsername(String username) {
		
		User user = userDao.getUserByUsername(username);
		return user ==null;
	}

}
