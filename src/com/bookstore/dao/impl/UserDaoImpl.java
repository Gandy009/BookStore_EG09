package com.bookstore.dao.impl;

import com.bookstore.bean.User;
import com.bookstore.dao.BaseDao;
import com.bookstore.dao.UserDao;
/**
 * UserDao的实现类
 * @author syd
 *
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public User getUserByUsernameAndPassword(User user) {
		
		//准备sql模版
		String sql = "SELECT id , username , password , email FROM bs_user WHERE username=? AND password=?";
		return this.getBean(sql, user.getUsername(),user.getPassword());
	}

	@Override
	public int savaUser(User user) {
		
		String sql ="INSERT INTO bs_user(username,password,email) VALUES(?,?,?)";
		
		try{
			return this.updata(sql, user.getUsername() , user.getPassword() , user.getEmail());
		}catch(Exception e){
			return 0;
		}
		
	}

	@Override
	public User getUserByUsername(String username) {
		String sql = "SELECT id , username , password , email FROM bs_user WHERE username=?";
		return this.getBean(sql, username);
	}

}
