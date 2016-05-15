package com.bookstore.bean;
/**
 * 封装订单项信息的类
 * @author syd
 *
 */
public class OrderItem {
	private Integer id;
	/**
	 * int count
	 *   单个商品买了多少件
	 */
	private int count;
	/**
	 * double amount
	 *   当前商品的小计金额
	 */
	private double amount;
	/**
	 * String title 　书名
	 */
	private String title;
	/**
	 * String author
	 *   作者
	 */
	private String author;
	/**
	 * double price
	 *   单价
	 */
	private double price;
	/**
	 * String imgPath
	 *   封面
	 */
	private String imgPath;
	/**
	 * String orderId
	 *   订单项所属的订单号
	 */
	private String orderId;
	public OrderItem() {
		super();
	}
	public OrderItem(Integer id, int count, double amount, String title,
			String author, double price, String imgPath, String orderId) {
		super();
		this.id = id;
		this.count = count;
		this.amount = amount;
		this.title = title;
		this.author = author;
		this.price = price;
		this.imgPath = imgPath;
		this.orderId = orderId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", count=" + count + ", amount="
				+ amount + ", title=" + title + ", author=" + author
				+ ", price=" + price + ", imgPath=" + imgPath + ", orderId="
				+ orderId + "]";
	}

}
