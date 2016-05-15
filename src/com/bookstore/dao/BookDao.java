package com.bookstore.dao;

import java.util.List;

import com.bookstore.bean.Book;
import com.bookstore.bean.Page;

/**
 * 定义图书相关的数据库操作的方法
 * @author syd
 *
 */
public interface BookDao {
	
	/**
	 * int saveBook(Book book);
	 * 向数据库中插入一本图书
	 */
	int savaBook(Book book);
	/**
	 * int delBook(String bookId);  
	 * 根据id从数据库中删除一本图书
	 */
	int delBook(String bookId);
	/**
	 * int updateBook(Book book); 
	 *  更新图书的信息
	 */
	int updateBook(Book book);
	/**
	 * Book getBookById(String bookId);
	 *   根据id查询一本图书的信息
	 */
	Book getBookById(String bookId);
	/**
	 * 查找所有图书
	 */
	List<Book> getBookList();
	/**
	 * 分页查找图书的信息
	 * @param page
	 * @return
	 */
	Page<Book> findBook(Page<Book> page);
	/**
	 * 根据价格查找分页信息
	 * @param page
	 * @param min
	 * @param max
	 * @return
	 */
	Page<Book> findBookByPrice(Page<Book> page,double min , double max);
	/**
	 * 批量修改图书的销量和库存
	 * @param params
	 */
	void batchUpdateSalesAndStock(Object[][] params);

}
