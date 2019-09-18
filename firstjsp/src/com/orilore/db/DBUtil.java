package com.orilore.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/test";
	private static String uid = "root";
	private static String pwd = "liren5a122";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, pwd);
		} catch (SQLException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return conn;
	}
}
