package com.bookstore.dao;

import com.bookstore.bean.User;

/**
 * 定义User相关的数据库方法
 * @author syd
 *
 */
public interface UserDao {
	/**
	 * 根据用户名和密码查询一个用户对象
	 */
	User getUserByUsernameAndPassword(User user);
	/**
	 * 将一个用户对象添加到数据库中
	 * @param user
	 * @return
	 */
	int savaUser(User user);
	/**
	 * 根据用户名查找用户对象
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username);

}
