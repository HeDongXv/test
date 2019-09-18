package com.lore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lore.db.DBUtil;
import com.lore.model.Kind;

public class KindDAO {
	// �������ݿ����Ӷ���
	private Connection conn;
	// ����SQL���ִ����
	private PreparedStatement ps;

	// �ر����ݿ�ӿڶ���
	public void close() {
		try {
			if(this.ps!=null) this.ps.close();
			if(this.conn!=null&&!this.conn.isClosed()) this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ɾ��kind����һ����¼
	 */
//	public void delete() {
//		String sql = "delete from kind where id=?";
//		this.conn = DBUtil.getConnector();
//	}
	
	/**
	 * ��kind�������һ���¼�¼
	 * @param args
	 */
	public boolean insert(Kind bean) {
		boolean flag=false;
		String name=bean.getName();
		String sql="insert into kind(name) values(?)";
		try {
			//��������
			this.conn=DBUtil.getConnector();
			//�������
			this.ps=conn.prepareStatement(sql);
			//ִ����� 
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
