package com.bookstore.servlet.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.User;
import com.bookstore.service.UserService;
import com.bookstore.service.impl.UserServiceImpl;

/**
 * 处理注册业务的Servlet
 * 
 * @author syd
 *
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 创建一个UserService
	private UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取用户发送的信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		// 将用户信息封装为一个USer对象
		User user = new User(null, username, password, email);
		
		//调用Service将User插入进数据库
		boolean regist = userService.regist(user);
		
		if(regist){
			//注册成功，重定向到regist-success.html
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.html");
		}else{
			//注册失败，转发到regist.html
			request.getRequestDispatcher("/pages/user/regist_success.html").forward(request, response);
		}

	}

}
