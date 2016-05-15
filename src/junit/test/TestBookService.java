package junit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.bookstore.bean.Book;
import com.bookstore.bean.Page;
import com.bookstore.dao.BookDao;
import com.bookstore.dao.impl.BookDaoImpl;
import com.bookstore.service.BookService;
import com.bookstore.service.impl.BookServiceImpl;
import com.bookstore.servlet.BaseServlet;

public class TestBookService {
	BookDao bookDao = new BookDaoImpl();
	
	BookService bookService = new BookServiceImpl();
	@Test
	public void testfindBookByPrice(){
		Page<Book> page = new Page<Book>();
		
		page.setPageNumber(1);
		page.setPageSize(4);
		Page<Book> pg = bookDao.findBookByPrice(page, 10, 20);
		
		List<Book> data = pg.getData();
		
		for (Book book : data) {
			System.out.println(book);
			
		}
	}

	@Test
	public void testFindBook() {
		Page<Book> page = bookService.findBook("3", 4);
		
		List<Book> data = page.getData();
		
		for (Book book : data) {
			System.out.println(book);
		}
	}

}
