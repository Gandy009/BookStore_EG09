package com.bookstore.service.impl;

import java.util.Date;
import java.util.List;

import com.bookstore.bean.Book;
import com.bookstore.bean.Cart;
import com.bookstore.bean.CartItem;
import com.bookstore.bean.Order;
import com.bookstore.bean.OrderItem;
import com.bookstore.bean.User;
import com.bookstore.dao.BookDao;
import com.bookstore.dao.OrderDao;
import com.bookstore.dao.OrderItemDao;
import com.bookstore.dao.impl.BookDaoImpl;
import com.bookstore.dao.impl.OrderDaoImpl;
import com.bookstore.dao.impl.OrderItemDaoImpl;
import com.bookstore.service.OrderService;
import com.mysql.fabric.xmlrpc.base.Data;
/**
 * OrderService实现类
 * @author syd
 *
 */
public class OrderServiceImpl implements OrderService {
	//创建三个Dao
	BookDao bookDao = new BookDaoImpl();
	OrderDao orderDao = new OrderDaoImpl();
	OrderItemDao itemDao = new OrderItemDaoImpl();

	@Override
	public String createOrder(Cart cart, User user) {
		//获取用户id
		int userId = user.getId();
		//生成订单好
		String orderId =System.currentTimeMillis()+""+userId;
		//获取商品的总数量
		int totalCount = cart.getTotalCount();
		//获取商品的总金额
		double totalAmount = cart.getTotalAmount();
		
		//创建一个Order
		Order order =new Order(orderId, new Date(), totalCount, totalAmount, 0, userId);
		//将Order插入到数据库
		orderDao.savaOrder(order);
		
		//获取CartItem购物项
		List<CartItem> cartItems = cart.getCartItems();
		
		Object[][] itemParams =new Object[cartItems.size()][];
		Object[][] bookParams =new Object[cartItems.size()][];
		
		//遍历CartItems
		for (int i=0;i<cartItems.size();i++) {
			CartItem cartItem =cartItems.get(i);
			//获取商品的数量
			int count = cartItem.getCount();
			
			//获取商品的金额
			double amount = cartItem.getAmount();
			//获取图书
			Book book = cartItem.getBook();
			//获取图书的信息
			String title = book.getTitle();
			Double price = book.getPrice();
			String author = book.getAuthor();
			String imgPath = book.getImgPath();
			
			//获取图书的销量及库存
			Integer sales = book.getSales();
			Integer stock = book.getStock();
			
			//创建OrderItem
			OrderItem orderItem = new OrderItem(null, count, amount, title, author, price, imgPath, orderId);
			
			//将OrderItem插入到数据库
			//itemDao.savaOrderItem(orderItem);
			
			//设置OrderItem的参数
			//count, amount, title, author, price, img_path, order_id
			itemParams[i]=new Object[]{count,amount,title,author,price,imgPath,orderId};
			
			//如果库存小于0
			if(stock-count<0){
				//抛出一个异常
				throw new RuntimeException("库存不足");
				
			}
			//设置book的参数
			//sales=? , stock=? WHERE id=?
			bookParams[i]=new Object[]{sales+count,stock-count,book.getId()};
			
		}
		//执行批处理
		bookDao.batchUpdateSalesAndStock(bookParams);
		itemDao.batchSavaOrderItem(itemParams);
		//订单已经生成，清空购物车
		cart.clear();
		
		
		return orderId;
	}

	@Override
	public List<Order> getOrderListByUserId(String userId) {
		
		return orderDao.getOrderListByUserId(userId);
	}

	@Override
	public List<OrderItem> getOrderItemList(String orderId) {
		
		return itemDao.getOrderItemList(orderId);
	}

	@Override
	public List<Order> getOrderList() {
		
		return orderDao.getOrderList();
	}

	@Override
	public void sendBook(String orderId) {
		orderDao.updateOrderState(orderId, 1);
		
	}

	@Override
	public void takeBook(String orderId) {
		orderDao.updateOrderState(orderId, 2);
		
	}

}
