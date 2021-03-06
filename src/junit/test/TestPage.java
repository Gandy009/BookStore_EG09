package junit.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bookstore.bean.Book;
import com.bookstore.bean.Page;

public class TestPage {

	@Test
	public void testPage() {
		Page<Book> page = new Page<Book>();
		
		//设置一个当前页码
		page.setPageNumber(3);
		
		//设置每页显示的条数
		page.setPageSize(4);
		
		//设置一个总记录数
		page.setTotalRecord(32);
		
		System.out.println("总页数："+page.getTotalPage());
		System.out.println("索引："+page.getIndex());
	}

}
