package junit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.bookstore.bean.Book;
import com.bookstore.bean.Page;
import com.bookstore.dao.BookDao;
import com.bookstore.dao.impl.BookDaoImpl;

public class TestBookDao {
	
	//创建一个BookDao的实例
	BookDao bookDao =new BookDaoImpl();

	@Test
	public void testBatch(){
		
		//第一维代表SQL语句执行的次数
		Object[][] params = new Object[3][];
		//第二维代表每次SQL语句执行时需要的参数
		//UPDATE bs_book SET sales=? , stock=? WHERE id=?
		params[0] = new Object[]{200,150,17};
		params[1] = new Object[]{200,150,18};
		params[2] = new Object[]{200,150,19};
		
		bookDao.batchUpdateSalesAndStock(params);
		
	}
	@Test
	public void testFindBook(){
		//创建一个Page对象
		Page<Book> page = new Page<Book>();
		
		//设置一个当前页码
		page.setPageNumber(-100);
		
		//设置一个pageSize
		page.setPageSize(4);
		
		//调用Dao
		Page<Book> pg = bookDao.findBook(page);
		
		List<Book> data = pg.getData();
		
		for (Book book : data) {
			System.out.println(book);
		}
	}

	@Test
	public void testSavaBook() {
		//创建一个图书的对象
		Book book = new Book(null, "三国演义", "罗贯中", 20.0, 100, 100, "/static/img/default.jpg");
		
		//将Book插入进数据库
		int count = bookDao.savaBook(book);
		System.out.println(count);
	}

	@Test
	public void testDelBook() {
		int count = bookDao.delBook("1");
		System.out.println(count);
	}

	@Test
	public void testUpdateBook() {
		Book book = new Book(15, "三国演义2", "老罗", 20.0, 100, 100, "/static/img/default.jpg");
		
		int count = bookDao.updateBook(book);
		System.out.println(count);
	}

	@Test
	public void testGetBookById() {
		Book book = bookDao.getBookById("10");
		System.out.println(book);
	}

	@Test
	public void testGetBookList() {
		List<Book> list = bookDao.getBookList();
		
		System.out.println(list);
	}

}
