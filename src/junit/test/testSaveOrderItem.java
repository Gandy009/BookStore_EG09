package junit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.bookstore.bean.OrderItem;
import com.bookstore.dao.OrderItemDao;
import com.bookstore.dao.impl.OrderItemDaoImpl;

public class testSaveOrderItem {
	//创建OrderItemDao
		OrderItemDao dao = new OrderItemDaoImpl();

		@Test
		public void testSaveOrderItem() {
			
			OrderItem orderItem = new OrderItem(null, 2, 10, "三国演义", "老罗", 5, "hello", "14512997203884");
			
			
			//将orderItem存储到数据库
			dao.savaOrderItem(orderItem);
			
		}
		
		@Test
		public void testGetOrderItemList(){
			List<OrderItem> list = dao.getOrderItemList("14512997203884");
			
			System.out.println(list);
		}

	}
