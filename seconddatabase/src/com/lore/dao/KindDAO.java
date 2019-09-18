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
			ResultSet rs = stmt.executeQuery(sql);  //ָ���ͷ
			while(rs.next()) {						//����ָ��������
				int id = rs.getInt("id");			//��ȡ��
				String name = rs.getString("name");
				System.out.println(id+"\t"+name);
			}
		   /*rs.last();//ָ��ָ������ĩβ
		    while(rs.previous()) {//ָ����ǰ�ƶ�
		    	int id = rs.getInt("id");			
				String name = rs.getString("name");
				System.out.println(id+"\t"+name);
		    }
		    System.out.println(rs.absolute(2));   //��ָ��ָ���ض���
		    */
		    
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
