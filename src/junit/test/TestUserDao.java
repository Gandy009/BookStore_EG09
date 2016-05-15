package junit.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bookstore.bean.User;
import com.bookstore.dao.UserDao;
import com.bookstore.dao.impl.UserDaoImpl;

public class TestUserDao {
	// 创建UserDao对象
	UserDao userDao = new UserDaoImpl();

	@Test
	public void testGetUserByUsernameAndPassword() {
		// 创建一个User
		User user = new User(null, "admin", "123123", null);

		// 调用Dao
		User loginUser = userDao.getUserByUsernameAndPassword(user);
		System.out.println(loginUser);
	}

	@Test
	public void testSavaUser() {
		// 创建一个User对象
		User user = new User(null, "admin", "123123", "ad@ad.com");

		// 调用DAO将用户插入进数据库
		int count = userDao.savaUser(user);

		System.out.println(count);
	}

}
