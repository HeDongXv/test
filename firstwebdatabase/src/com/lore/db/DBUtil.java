package com.lore.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * �ṩ�������Ӷ���Ĺ�����
 * @author 
 *
 */

public class DBUtil {

	private static String url="jdbc:mysql://localhost:3306/test";
	private static String uid="root";
	private static String pwd="liren5a122";
	/**
	 * ����MySQL���ݿ�����
	 */
	public static Connection getConnector() {
		Connection conn=null;
		try {
			//ע������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			conn=DriverManager.getConnection(url,uid,pwd);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
