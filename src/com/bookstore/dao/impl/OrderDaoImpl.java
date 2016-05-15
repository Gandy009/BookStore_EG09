package com.bookstore.dao.impl;

import java.util.List;

import com.bookstore.bean.Order;
import com.bookstore.dao.BaseDao;
import com.bookstore.dao.OrderDao;
/**
 * OrderDao的实现类
 * @author syd
 *
 */
public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

	@Override
	public int savaOrder(Order order) {
		//sql模版
		String sql = "INSERT INTO bs_order(id , order_time , total_count , total_amount , state , user_id) "
				+ "VALUES(?,?,?,?,?,?)";
		return this.updata(sql, order.getId(), order.getOrderTime(),
				order.getTotalCount(), order.getTotalAmount(),
				order.getState(), order.getUserId());
	}

	@Override
	public List<Order> getOrderListByUserId(String userId) {
		String sql = "SELECT id , order_time orderTime , total_count totalCount , "
				+ "total_amount totalAmount , state , user_id userId "
				+ "FROM bs_order WHERE user_id=? ORDER BY order_time DESC";
		return this.getBeanList(sql, userId);
	}

	@Override
	public List<Order> getOrderList() {
		String sql = "SELECT id , order_time orderTime , total_count totalCount , "
				+ "total_amount totalAmount , state , user_id userId "
				+ "FROM bs_order ";
		return this.getBeanList(sql);
	}

	@Override
	public int updateOrderState(String orderId, int state) {
		
		String sql = "UPDATE bs_order SET state=? WHERE id=?";
		return this.updata(sql, state,orderId);
	}

}
