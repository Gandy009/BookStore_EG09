package com.bookstore.dao;

import java.util.List;

import com.bookstore.bean.Order;

/**
 * 定义订单和数据库操作的基本方法
 * @author syd
 *
 */
public interface OrderDao {
	/**
	 * 将一个订单插入进数据库
	 * @param order
	 * @return
	 */
	int savaOrder(Order order);
	/**
	 * 根据用户的id查询订单，有普通用户调用
	 * @param userId
	 * @return
	 */
	List<Order> getOrderListByUserId(String userId);

	/**
	 * 查询所有订单，由管理员调用
	 * @return
	 */
	List<Order> getOrderList();
	/**
	 * 修改指定订单的状态
	 * @param orderId
	 * @param state
	 * @return
	 */
	int updateOrderState(String orderId,int state);

}
