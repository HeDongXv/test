package com.orilore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.orilore.db.DBUtil;
import com.orilore.entity.Area;
import com.orilore.entity.City;

public class AreaDAO implements IAreaDAO {

	DBUtil db = new DBUtil();
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public void close() {
		try {
			if(rs!=null)this.rs.close();
			if(ps!=null) this.ps.close();
			if(conn!=null && !conn.isClosed()) this.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insert(Area area) {
		String sql = "insert into area(name,cid) values(?,?)";
		try {
			this.conn = db.getConnection();
			this.ps = conn.prepareStatement(sql);
			this.ps.setString(1, area.getName());
			this.ps.setInt(2, area.getCid());
			if(ps.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			this.close();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		String sql = "delete from area where id=?";
		try {
			this.conn = db.getConnection();
			this.ps = conn.prepareStatement(sql);
			this.ps.setInt(1, id);
			if(ps.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			this.close();
		}
		return false;
	}

	@Override
	public boolean update(Area area) {
		String sql = "update area set name=?,cid=? where id=?";
		try {
			this.conn = db.getConnection();
			this.ps = conn.prepareStatement(sql);
			this.ps.setString(1, area.getName());
			this.ps.setInt(2, area.getCid());
			this.ps.setInt(3, area.getId());
			if(ps.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			this.close();
		}
		return false;
	}

	@Override
	public List<Area> select(Integer cid) {
		String sql = "select * from area where cid=?";
		List<Area> ar = new ArrayList<Area>();
		try {
			this.conn = db.getConnection();
			this.ps = conn.prepareStatement(sql);
			this.ps.setInt(1, cid);
			this.rs = this.ps.executeQuery();
			while(rs.next()) {
				Area bean = new Area();
				bean.setId(rs.getInt("id"));
				bean.setCid(rs.getInt("cid"));
				bean.setName(rs.getString("name"));
				ar.add(bean);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			this.close();
		}
		return ar;
	}

	@Override
	public Area selectOne(int id) {
		String sql = "select * from area where id=?";
		Area bean = null;
		try {
			this.conn = db.getConnection();
			this.ps = conn.prepareStatement(sql);
			this.ps.setInt(1, id);
			this.rs = this.ps.executeQuery();
			if(rs.next()) {
				bean = new Area();
				bean.setId(rs.getInt("id"));
				bean.setCid(rs.getInt("cid"));
				bean.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			this.close();
		}
		return bean;
	}

}
