package com.orilore.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {

	private static String url;
	private static String uid;
	private static String pwd;
	private static String driver;
	
	static {
		try {
			Properties prop = new Properties();
			InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
			prop.load(is);
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			uid = prop.getProperty("username");
			pwd = prop.getProperty("password");
			is.close();
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	
	public static Connection getConnection() {
		try {
//			InputStream in = this.getClass().getResourceAsStream("Config.properties");
//			Properties prop = new Properties();
//			prop.load(in);
//			Class.forName(prop.getProperty("driver"));
//			Connection conn = DriverManager.getConnection( prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,uid,pwd);
			
			//in.close();
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	
//	public static void main(String[] args) {
//		try {
//		//	DBUtil db = new DBUtil();
//			Connection conn = DBUtil.getConnection();
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery("select * from kinds");
//			while(rs.next()) {
//				String name = rs.getString("name");
//				System.out.println(name);
//			}
//			rs.close();
//			stmt.close();
//			conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}


