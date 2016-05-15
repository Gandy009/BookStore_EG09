package junit.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.bookstore.bean.Order;
import com.bookstore.dao.OrderDao;
import com.bookstore.dao.impl.OrderDaoImpl;

public class TestOrderDao {
	OrderDao orderDao = new OrderDaoImpl();

	@Test
	public void testSavaOrder() {
		//获取一个用户id
		int userId = 4;
		//生成一个订单号。时间戳+“”+userId
		String id = System.currentTimeMillis()+""+userId;
		
		//创建一个order对象
		Order order =new Order(id, new Date(), 2, 20, 0, userId);
		
		//将order插入进数据库
		int count = orderDao.savaOrder(order);
		
		System.out.println(count);
	}

	@Test
	public void testGetOrderListByUserId() {
		List<Order> orderList = orderDao.getOrderListByUserId("4");
		
		System.out.println(orderList);
	}

	@Test
	public void testGetOrderList() {
		List<Order> list= orderDao.getOrderList();
		System.out.println(list);
	}

	@Test
	public void testUpdateOrderState() {
		orderDao.updateOrderState("14512997203884", 1);
	}

}
