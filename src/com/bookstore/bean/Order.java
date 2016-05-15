package com.bookstore.bean;

import java.util.Date;

/**
 * 封装订单信息的类
 * @author syd
 *
 */
public class Order {
	/**
	 * 订单号 规则：时间戳+""+用户ID
	 */
	private String id;
	/**
	 * 时间生成时间
	 */
	private Date OrderTime;
	/**
	 * 商品的总数量
	 */
	private int totalCount;
	/**
	 * 商品的总金额
	 */
	private double totalAmount;
	/**
	 * 订单的状态： 0:未发货 1:已发货 2:交易完成
	 */
	private int state;
	/**
	 *订单所属用户的ID
	 */
	private int userId;
	@Override
	public String toString() {
		return "Order [id=" + id + ", OrderTime=" + OrderTime + ", totalCount="
				+ totalCount + ", totalAmount=" + totalAmount + ", state="
				+ state + ", userId=" + userId + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getOrderTime() {
		return OrderTime;
	}
	public void setOrderTime(Date orderTime) {
		OrderTime = orderTime;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Order(String id, Date orderTime, int totalCount, double totalAmount,
			int state, int userId) {
		super();
		this.id = id;
		OrderTime = orderTime;
		this.totalCount = totalCount;
		this.totalAmount = totalAmount;
		this.state = state;
		this.userId = userId;
	}
	public Order() {
		super();
	}
	

}
