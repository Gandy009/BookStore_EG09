package com.bookstore.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.jmx.snmp.ThreadContext;

/**
 * 获取和释放数据库连接的工具类
 * @author syd
 *
 */
public class JDBCUtils {
	//获取数据源
	private static DataSource dataSource = new ComboPooledDataSource("webDataSource");
	
	//获取一个Map来保存数据库连接
	//private static Map<Thread,Connection> map = new ConcurrentHashMap<Thread, Connection>();
	
	//创建一个ThreadLocal对象
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	//获取数据库连接
	public static Connection getConnectin() {
		
		//从ThreadLocal获取当前线程的Connection
		Connection conn = threadLocal.get();
		
		if(conn ==null){
			try {
				conn =dataSource.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//将conn保存到ThreadLocal
			threadLocal.set(conn);
		}
		return conn;
		
		/*//获取当前线程的数据库连接
		Connection conn = map.get(Thread.currentThread());
		
		//判断conn是否为null
		if(conn ==null){
			//创建一个新的数据库连接
			try {
				conn = dataSource.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//将conn放入到map中
			map.put(Thread.currentThread(), conn);
		}
		return conn;*/
	}
	/**
	 * 释放数据库连接
	 * @param conn
	 */
	public static void releaseConnection(){
		
		//获取当前线程的Connection
		Connection conn = threadLocal.get();
		
		//关闭数据库连接
		if(conn !=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//从ThreadLocal中移除conn
		threadLocal.remove();
		
		
		
		/*//获取当前线程的Connection
		Connection conn = map.get(Thread.currentThread());
		
		//关闭当前线程的Connection
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			map.remove(Thread.currentThread());
		}*/
	}
	
	//释放数据库连接的方法
	public static void releaseConnection(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
