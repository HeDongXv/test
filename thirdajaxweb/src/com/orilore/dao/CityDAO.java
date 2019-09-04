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

public class CityDAO implements ICityDAO {

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
	public boolean insert(City city) {
		String sql = "insert into city(name) values(?)";
		try {
			this.conn = db.getConnection();
			this.ps = conn.prepareStatement(sql);
			this.ps.setString(1, city.getName());
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
		String sql = "delete from city where id=?";
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
	public boolean update(City city) {
		String sql = "update city set name=? where id=?";
		try {
			this.conn = db.getConnection();
			this.ps = conn.prepareStatement(sql);
			this.ps.setString(1, city.getName());
			this.ps.setInt(2, city.getId());
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
	public List<City> select() {
		String sql = "select * from city";
		List<City> cs = new ArrayList<City>();
		try {
			this.conn =db.getConnection();
			this.ps = conn.prepareStatement(sql);
			this.rs = this.ps.executeQuery();
			while(rs.next()) {
				City bean = new City();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				cs.add(bean);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			this.close();
		}
		return cs;
	}

	@Override
	public City selectOne(int id) {
		String sql = "select * from city where id=?";
		City bean = null;
		try {
			this.conn = db.getConnection();
			this.ps = conn.prepareStatement(sql);
			this.ps.setInt(1, id);
			this.rs = this.ps.executeQuery();
			if(rs.next()) {
				bean = new City();
				bean.setId(rs.getInt("id"));
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
