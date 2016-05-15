package com.bookstore.servlet.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.Book;
import com.bookstore.bean.Page;
import com.bookstore.service.BookService;
import com.bookstore.service.impl.BookServiceImpl;
import com.bookstore.servlet.BaseServlet;
import com.bookstore.util.WEBUtils;

public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	// 创建BookService
	private BookService bookService = new BookServiceImpl();

	/**
	 * 根据价格查找图书信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void findBookByPrice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取页面
		String pageNumber = request.getParameter("pageNumber");
		//指定一个pageSize
		int pageSize=4;
		//获取最高和最低的价格
		String min = request.getParameter("min");
		String max = request.getParameter("max");
		
		//调用Service查询分页数据
		Page<Book> page = bookService.findBookByPrice(pageNumber, pageSize, min, max);
		
		//设置请求路径
		page.setPath(WEBUtils.getPath(request));
		
		//将page对象放入到req域中
		request.setAttribute("page", page);
		
		//转发到index.jsp
		request.getRequestDispatcher("/pages/book/book-list.jsp").forward(request, response);

	}

	/**
	 * 客户端分页查找图书的方法
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void findBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取页码
		String pageNumber = request.getParameter("pageNumber");
		// 设置一个pageSize
		int pageSize = 4;

		// 调用service查询分页信息
		Page<Book> page = bookService.findBook(pageNumber, pageSize);

		// 获取请求的路径
		String path = WEBUtils.getPath(request);

		// 将path设置进page对象
		page.setPath(path);

		// 将page放入到域对象中
		request.setAttribute("page", page);

		// 转发到index.jsp
		request.getRequestDispatcher("/pages/book/book-list.jsp").forward(
				request, response);

	}

}
