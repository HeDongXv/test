package com.orilore.dao.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.orilore.dao.IKindDAO;
import com.orilore.db.DBUtil;
import com.orilore.model.Kind;

public class KindDAO implements IKindDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn!=null&&!conn.isClosed()) conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public boolean insert(Kind bean) {
		boolean flag = false;
		String sql = "insert into kind(name) values(?)";
		try {
			this.conn = DBUtil.getConnection();
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, bean.getName());
			if(ps.executeUpdate()>0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		return flag;
	}

	@Override
	public boolean update(Kind bean) {
		String sql = "update kind set name=? where id=?";
		try {
			this.conn = DBUtil.getConnection();
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, bean.getName());
			this.ps.setInt(2, bean.getId());
			if(this.ps.executeUpdate()>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		
		String sql = "delete from kind where id=?";
		try {
			this.conn = DBUtil.getConnection();
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, id);
			if(this.ps.executeUpdate()>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		return false;
	}

	@Override
	public List<Kind> select() {
		ArrayList<Kind> kinds = new ArrayList<Kind>();
		String sql = "select * from kind order by id desc";
		try {
			this.conn = DBUtil.getConnection();
			this.ps = this.conn.prepareStatement(sql);
			this.rs = this.ps.executeQuery();
			while(rs.next()) {
				Kind bean = new Kind();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				kinds.add(bean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			this.close();
		}
		return kinds;
	}

	@Override
	public Kind select(int id) {
		Kind bean = null;
		String sql = "select * from kind where id=?";
		try {
			this.conn = DBUtil.getConnection();
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, id);
			this.rs = this.ps.executeQuery();
			if(rs.next()) {
				bean = new Kind();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			this.close();
		}
	return bean;
	}

}
