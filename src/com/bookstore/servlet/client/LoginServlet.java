package com.bookstore.servlet.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.User;
import com.bookstore.service.UserService;
import com.bookstore.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //创建一个UserService
	private UserService userService = new UserServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户填写的用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//将两个属性封装为User对象
		User loginUser = new User(null, username, password, null);
		
		//判断loginUser是否null
		if(loginUser == null){
			System.out.println("错了");
			//登录失败，用户名或密码错误。转发到login.html重新输入
			request.getRequestDispatcher("/pages/user/login.html").forward(request, response);
		}else{
			System.out.println("对了");
			//登录成功 重定向到login-success.html
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.html");
		}
	}

}
