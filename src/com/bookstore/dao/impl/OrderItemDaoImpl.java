package com.bookstore.dao.impl;

import java.util.List;

import com.bookstore.bean.OrderItem;
import com.bookstore.dao.BaseDao;
import com.bookstore.dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDao<OrderItem> implements
		OrderItemDao {

	@Override
	public int savaOrderItem(OrderItem orderItem) {
		String sql="INSERT INTO bs_order_item(count, amount, title, author, price, img_path, order_id) "
				+ "VALUES(?,?,?,?,?,?,?)";
		return this.updata(sql, orderItem.getCount(), orderItem.getAmount(),
				orderItem.getTitle(), orderItem.getAuthor(),
				orderItem.getPrice(), orderItem.getImgPath(),
				orderItem.getOrderId());
	}

	@Override
	public List<OrderItem> getOrderItemList(String orderId) {
		String sql = "SELECT id, count, amount, title, author, price, img_path imgPath, order_id orderId "
				+ "FROM bs_order_item WHERE order_id=? ORDER BY DESC";
		return this.getBeanList(sql, orderId);
	}

	@Override
	public void batchSavaOrderItem(Object[][] params) {
		String sql = "INSERT INTO bs_order_item(count, amount, title, author, price, img_path, order_id) "
				+ "VALUES(?,?,?,?,?,?,?)";
		this.bacth(sql, params);
		
	}

}
