package com.bookstore.service.impl;

import java.util.List;

import com.bookstore.bean.Book;
import com.bookstore.bean.Page;
import com.bookstore.dao.BookDao;
import com.bookstore.dao.impl.BookDaoImpl;
import com.bookstore.service.BookService;

public class BookServiceImpl implements BookService {
	
	//创建一个BookDao
	BookDao bookDao = new BookDaoImpl();

	@Override
	public int savaBook(Book book) {
		
		return bookDao.savaBook(book);
	}

	@Override
	public int delBook(String bookId) {
		return bookDao.delBook(bookId);
	}

	@Override
	public int updateBook(Book book) {
		return bookDao.updateBook(book);
	}

	@Override
	public Book getBookById(String bookId) {
		// TODO Auto-generated method stub
		return bookDao.getBookById(bookId);
	}

	@Override
	public List<Book> getBookList() {
		
		return bookDao.getBookList();
	}

	@Override
	public Page<Book> findBook(String pageNumber, int pageSize) {
		//指定一个默认值
		int pn = 1;
		
		//将pageNumber转换为int类型
		try{
			pn = Integer.parseInt(pageNumber);
		}catch(NumberFormatException e){
			
		}
		//创建Page对象
		Page<Book> page = new Page<Book>();
		
		//设置pageNumber
		page.setPageNumber(pn);
		
		//设置pageSize
		page.setPageSize(pageSize);
		
		return bookDao.findBook(page);
	}

	@Override
	public Page<Book> findBookByPrice(String pageNumber, int pageSize,
			String min, String max) {
		
		//指定一个默认值
		int pn=1;
		//将pageNumber转换为int类型
		try{
			pn=Integer.parseInt(pageNumber);
		}catch(NumberFormatException e){
			
		}
		//创建Page对象
		Page<Book> page = new Page<Book>();
		//设置pageNumber
		page.setPageNumber(pn);
		//设置pageSize
		page.setPageSize(pageSize);
		// 将min和max转换为double类型
		// 指定一个默认值
		double minPrice = 0;
		double maxPrice = Double.MAX_VALUE;
		//转型
		
		try{
			minPrice=Double.parseDouble(min);
		}catch(Exception e){
			
		}
		try{
			maxPrice=Double.parseDouble(max);
		}catch(Exception e){
			
		}
		
		
		return bookDao.findBookByPrice(page, minPrice, maxPrice);
	}

}
