package com.bookstore.bean;

import java.io.Serializable;

/**
 * 封装图书信息的类
 * @author syd
 *
 */
public class Book implements Serializable{
	private Integer id;
	/**
	 * 书名
	 */
	private String title;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 销量
	 */
	private Double price;
	/**
	 * 单价
	 */
	private Integer sales;
	/**
	 * 库存
	 */
	private Integer stock;
	/**
	 * 图片路径
	 */
	private String imgPath = "/static/img/default.jpg";
	public Book() {
		super();
	}
	public Book(Integer id, String title, String author, Double price,
			Integer sales, Integer stock, String imgPath) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.sales = sales;
		this.stock = stock;
		this.imgPath = imgPath;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author
				+ ", price=" + price + ", sales=" + sales + ", stock=" + stock
				+ ", imgPath=" + imgPath + "]";
	}
	

}
