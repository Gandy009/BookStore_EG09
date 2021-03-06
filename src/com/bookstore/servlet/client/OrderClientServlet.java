package com.bookstore.servlet.client;

import com.bookstore.bean.Cart;
import com.bookstore.bean.Order;
import com.bookstore.bean.OrderItem;
import com.bookstore.bean.User;
import com.bookstore.service.OrderService;
import com.bookstore.service.impl.OrderServiceImpl;
import com.bookstore.servlet.BaseServlet;
import com.bookstore.util.WEBUtils;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 处理客户端订单相关的请求Servlet
 * @author syd
 *
 */
public class OrderClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
	
    //创建OrderService
	private OrderService orderService = new OrderServiceImpl();
	/**
	 * 收货的方法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void takeBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取orderId
		String orderId = request.getParameter("orderId");
		//调用service来确认收获
		orderService.takeBook(orderId);
		//重定向到订单列表
		response.sendRedirect(request.getContextPath()+"/client/OrderClientServlet?method=orderList");
	}
	/**
	 * 查看订单详情
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void orderInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取orderId
		String orderId = request.getParameter("orderId");
		//调用service来查询订单详情
		List<OrderItem> list = orderService.getOrderItemList(orderId);
		
		//将订单项设置进request域中
		request.setAttribute("list", list);
		//转发到每个页面
		request.getRequestDispatcher("/pages/order/order-info.jsp").forward(request, response);
		
	}
	protected void orderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取httpSession
		HttpSession session = request.getSession();
		
		//获取loginUser
		User user = (User) session.getAttribute("loginUser");
		
		//检查用户是否登录
		/*if(user ==null){
			//没登录，设置一个错误消息
			request.setAttribute("msg", "该操作需要登录，请先登录");
			//转发到login.jsp
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else{*/
			//已登录，调用Service去查询订单列表
			List<Order> list = orderService.getOrderListByUserId(user.getId()+"");
			//将list放入到request域中
			request.setAttribute("list", list);
			
			//转发到/pages/order/order.jsp
			request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
			
		/*}*/
	}
	/**
	 * 处理用户结账请求的方法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取HttpSession
		HttpSession session = request.getSession();
		
		//获取loginUser
		User user = (User) session.getAttribute("loginUser");
		/*//检查用户是否登录
		if(user ==null){
			//没登录，设置一个错误消息
			request.setAttribute("msg", "该操作需要登录，请先登录");
			//转发到login.jsp
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else{*/
			//登录成功
			//获取购物车
			Cart cart = WEBUtils.getCart(request);
			//调用service生成订单
			String orderId = orderService.createOrder(cart, user);
			//将orderId设置到request域中
			request.setAttribute("orderId", orderId);
			//转发到/pages/cart/checkout.jsp
			request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request, response);
		/*}*/
	}

}
