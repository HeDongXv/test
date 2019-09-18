package com.lore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lore.db.DBUtil;
import com.lore.model.Kind;

public class KindDAO {
	// 声明数据库连接对象
	private Connection conn;
	// 声明SQL语句执行器
	private PreparedStatement ps;

	// 关闭数据库接口对象
	public void close() {
		try {
			if(this.ps!=null) this.ps.close();
			if(this.conn!=null&&!this.conn.isClosed()) this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除kind表中一条记录
	 */
//	public void delete() {
//		String sql = "delete from kind where id=?";
//		this.conn = DBUtil.getConnector();
//	}
	
	/**
	 * 向kind表中添加一条新记录
	 * @param args
	 */
	public boolean insert(Kind bean) {
		boolean flag=false;
		String name=bean.getName();
		String sql="insert into kind(name) values(?)";
		try {
			//建立连接
			this.conn=DBUtil.getConnector();
			//创建语句
			this.ps=conn.prepareStatement(sql);
			//执行语句 
			ps.setString(1, name);
			if(ps.executeUpdate()>0) {
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		return flag;
	}
	
//	public static void main(String[] args) {
//
//		KindDAO dao=new KindDAO();
//		Kind bean=new Kind();
//		bean.setName("PC");
//		boolean f=dao.insert(bean);
//		System.out.println(f);
//	}

}
