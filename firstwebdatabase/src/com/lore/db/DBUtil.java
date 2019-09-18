package com.lore.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 提供数据连接对象的工具类
 * @author 
 *
 */

public class DBUtil {

	private static String url="jdbc:mysql://localhost:3306/test";
	private static String uid="root";
	private static String pwd="liren5a122";
	/**
	 * 建立MySQL数据库连接
	 */
	public static Connection getConnector() {
		Connection conn=null;
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			conn=DriverManager.getConnection(url,uid,pwd);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
