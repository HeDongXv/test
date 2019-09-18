package com.lore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lore.db.DBUtil;

public class KindDAO {

	
	
	public static void main(String[] args) {

		try {
			Connection conn = DBUtil.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from kind";
			ResultSet rs = stmt.executeQuery(sql);  //指向表头
			while(rs.next()) {						//控制指针向下行
				int id = rs.getInt("id");			//读取列
				String name = rs.getString("name");
				System.out.println(id+"\t"+name);
			}
		   /*rs.last();//指针指向结果集末尾
		    while(rs.previous()) {//指针向前移动
		    	int id = rs.getInt("id");			
				String name = rs.getString("name");
				System.out.println(id+"\t"+name);
		    }
		    System.out.println(rs.absolute(2));   //将指针指向特定行
		    */
		    
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
