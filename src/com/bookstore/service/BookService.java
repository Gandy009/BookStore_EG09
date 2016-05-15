package com.bookstore.service;

import java.util.List;

import com.bookstore.bean.Book;
import com.bookstore.bean.Page;

/**
 * 定义图书相关的业务逻辑的接口
 * @author syd
 *
 */
public interface BookService {
	/**
	 * int saveBook(Book book);
	 *   向数据库中插入一本图书
	 */
	int savaBook(Book book);
	/**
	 * int delBook(String bookId);
	 *   根据id从数据库中删除一本图书
	 */
	int delBook(String booId);
	/**
	 * int updateBook(Book book);
	 *   更新图书的信息
	 */
	int updateBook(Book book);
	/**
	 * Book getBookById(String bookId);
	 *   根据id查询一本图书的信息
	 */
	Book getBookById(String bookId);
	/**
	 * List<Book> getBookList();
	 *   查询所有图书
	 */
	List<Book> getBookList();
	/**
	 * 分页查找图书
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	Page<Book> findBook(String pageNumber,int pageSize);
	
	Page<Book> findBookByPrice(String pageNumber, int pageSize, String min, String max);
}
