package junit.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.bookstore.util.JDBCUtils;

public class TestJDBCUtils {

	@Test
	public void testJDBCUtils() {
		Connection conn = JDBCUtils.getConnectin();
		System.out.println(conn);
		
		JDBCUtils.releaseConnection(conn);
	}

}
