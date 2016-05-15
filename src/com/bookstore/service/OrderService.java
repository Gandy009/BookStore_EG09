package com.bookstore.service;

import java.util.List;

import com.bookstore.bean.Cart;
import com.bookstore.bean.Order;
import com.bookstore.bean.OrderItem;
import com.bookstore.bean.User;

/**
 * 定义订单相关业务的接口
 * @author syd
 *
 */
public interface OrderService {
	/**
	 * 生成订单并返回订单号
	 * @param cart
	 * @param user
	 * @return
	 */
	String createOrder(Cart cart,User user);
	
	/**
	 * 根据用户的id查询订单
	 * @param userId
	 * @return
	 */	
	List<Order> getOrderListByUserId(String userId);
	/**
	 * 根据订单号获取所有的订单项
	 * @param orderId
	 * @return
	 */
	List<OrderItem> getOrderItemList(String orderId);
	/**
	 * 查询所有的订单
	 * @return
	 */
	List<Order> getOrderList();
	/**
	 * 发货的方法，由管理员调用
	 */
	void sendBook(String orderId);
	/**
	 * 收货的方法，由普通用户调用
	 */
	void takeBook(String orderId);

}
