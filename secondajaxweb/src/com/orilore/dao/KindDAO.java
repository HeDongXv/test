package com.orilore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.orilore.db.DBUtil;
import com.orilore.model.Kind;

public class KindDAO implements IKindDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public void close() {
		try {
			if(this.rs!=null) this.rs.close();
			if(this.ps!=null) this.ps.close();
			if(this.conn!=null && this.conn.isClosed()) this.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insert(Kind bean) {
		String sql = "insert into kinds(name,info) values(?,?)";
		try {
			this.conn = DBUtil.getConnectionn();
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, bean.getName());
			this.ps.setString(2, bean.getInfo());
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
	public boolean update(Kind bean) {
		String sql = "update kinds set name=?,info=? where id=?";
		try {
			this.conn = DBUtil.getConnectionn();
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, bean.getName());
			this.ps.setString(2, bean.getInfo());
			this.ps.setInt(3, bean.getId());
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
	public boolean delete(int id) {
		String sql = "delete from kinds where id=?";
		try {
			this.conn = DBUtil.getConnectionn();
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
		String sql = "select * from kinds order by id desc";
		List<Kind> list = new ArrayList<Kind>();
		try {
			this.conn = DBUtil.getConnectionn();
			this.ps = this.conn.prepareStatement(sql);
			this.rs = this.ps.executeQuery();
			while(this.rs.next()) {
				Kind bean = new Kind();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setInfo(rs.getString("info"));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		return list;
	}

	@Override
	public Kind selectOne(int id) {
		Kind bean = null;
		String sql = "select * from kinds where id=?";
		try {
			this.conn = DBUtil.getConnectionn();
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, id);
			this.rs = this.ps.executeQuery();
			if(this.rs.next()) {
				bean = new Kind();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setName(rs.getString("info"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		return bean;
	}

}
