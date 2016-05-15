package com.bookstore.dao.impl;

import java.util.List;

import com.bookstore.bean.Book;
import com.bookstore.bean.Page;
import com.bookstore.dao.BaseDao;
import com.bookstore.dao.BookDao;

/**
 * BookDao 的实现类
 * 
 * @author syd
 *
 */
public class BookDaoImpl extends BaseDao<Book> implements BookDao {

	@Override
	public int savaBook(Book book) {
		// 创建一个SQL模版
		String sql = "INSERT INTO bs_book(title, author, price, sales, stock, img_path) "
				+ "VALUES(?,?,?,?,?,?)";
		return this.updata(sql, book.getTitle(), book.getAuthor(),
				book.getPrice(), book.getSales(), book.getStock(),
				book.getImgPath());
	}

	@Override
	public int delBook(String bookId) {

		String sql = "DELETE FROM bs_book WHERE id=?";
		return this.updata(sql, bookId);
	}

	@Override
	public int updateBook(Book book) {

		String sql = "UPDATE bs_book SET title=? , author=? , price=? , sales=? , stock=? , img_path=? "
				+ "WHERE id=?";
		return this.updata(sql, book.getTitle(), book.getAuthor(),
				book.getPrice(), book.getSales(), book.getStock(),
				book.getImgPath(), book.getId());
	}

	@Override
	public Book getBookById(String bookId) {

		String sql = "SELECT id, title, author, price, sales, stock, img_path imgPath "
				+ "FROM bs_book WHERE id=?";
		return this.getBean(sql, bookId);
	}

	@Override
	public List<Book> getBookList() {

		String sql = "SELECT id, title, author, price, sales, stock, img_path imgPath "
				+ "FROM bs_book";
		return this.getBeanList(sql);
	}

	@Override
	public Page<Book> findBook(Page<Book> page) {
		/**
		 * 该方法由Service调用，page中已经封装好pageNumber和pageSize， 我们只需要获取totalRecord 和
		 * data即可
		 */

		// 查询总记录数
		// 创建一个SQL模版
		String sql = "SELECT COUNT(*) FROM bs_book";

		// 执行sql语句
		long totalRecord = (long) this.getSingleValue(sql);

		// 将总记录数设置进page对象
		page.setTotalRecord((int) totalRecord);

		// 查找数据
		// 创建sql模版
		// 创建SQL模板
		sql = "SELECT id, title, author, price, sales, stock, img_path imgPath "
		+ "FROM bs_book LIMIT ? , ?";
		// 执行查询
		List<Book> data = this.getBeanList(sql, page.getIndex(),
				page.getPageSize());
		// 将list放入到page对象中
		page.setData(data);

		return page;
	}

	@Override
	public Page<Book> findBookByPrice(Page<Book> page, double min, double max) {
		
		//先查找总记录数
		//创建一个sql模版
		String sql = "SELECT COUNT(*) FROM bs_book WHERE price>=? AND price<=?";
		//查询总记录数
		long totalRecord = (long) this.getSingleValue(sql, min,max);
		//将总记录数设置进page对象
		page.setTotalRecord((int) totalRecord);
		
		//查询分页图书信息
		sql="SELECT id, title, author, price, sales, stock, img_path imgPath "
				+ "FROM bs_book WHERE price>=? AND price<=? LIMIT ? , ?";
		//执行查询
		List<Book> data = this.getBeanList(sql, min, max, page.getIndex(), page.getPageSize());
		
		//将data放入到page对象中
		page.setData(data);
		return page;
	}

	@Override
	public void batchUpdateSalesAndStock(Object[][] params) {
		String sql = "UPDATE bs_book SET sales=? , stock=? WHERE id=?";
		
		this.bacth(sql, params);
	}

}
