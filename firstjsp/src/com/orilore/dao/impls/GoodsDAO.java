package com.orilore.dao.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.orilore.dao.IGoodsDAO;
import com.orilore.db.DBUtil;
import com.orilore.model.Goods;

public class GoodsDAO implements IGoodsDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public void close() {
		try {
			if(this.rs!=null) this.rs.close();
			if(this.ps!=null) this.ps.close();
			if(this.conn!=null && !this.conn.isClosed()) this.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insert(Goods bean) {
		String sql = "insert into goods(name,kid,size,price,addr,brand,info) values(?,?,?,?,?,?,?)";
		try {
			this.conn = DBUtil.getConnection();
			this.ps =  conn.prepareStatement(sql);
			this.ps.setString(1, bean.getName());
			this.ps.setInt(2, bean.getKid());
			this.ps.setString(3, bean.getSize());
			this.ps.setFloat(4, bean.getPrice());
			this.ps.setString(5, bean.getAddr());
			this.ps.setString(6, bean.getBrand());
			this.ps.setString(7, bean.getInfo());
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
		String sql = "delete from goods where id=?";
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
	public boolean update(Goods bean) {
		String sql = "update goods set name=?,size=?,price=?,brand=?,addr=?,info=?,kid=? where id=?";
		try {
			this.conn = DBUtil.getConnection();
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1,bean.getName());
			this.ps.setString(2,bean.getSize());
			this.ps.setFloat(3,bean.getPrice());
			this.ps.setString(4,bean.getBrand());
			this.ps.setString(5,bean.getAddr());
			this.ps.setString(6,bean.getInfo());
			this.ps.setInt(7,bean.getKid());
			this.ps.setInt(8,bean.getId());
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
	public List<Goods> select() {
		List<Goods> list = new ArrayList<Goods>();
		String sql = "select a.*,b.name kname from goods a left join kind b on a.kid=b.id order by id desc";
		try {
			this.conn = DBUtil.getConnection();
			this.ps = this.conn.prepareStatement(sql);
			this.rs = this.ps.executeQuery();
			while(rs.next()) {
				Goods bean = new Goods();
				bean.setKname(this.rs.getString("kname"));
				bean.setName(this.rs.getString("name"));
				bean.setAddr(this.rs.getString("addr"));
				bean.setBrand(this.rs.getString("brand"));
				bean.setPrice(this.rs.getFloat("price"));
				bean.setSize(this.rs.getString("size"));
				bean.setInfo(this.rs.getString("info"));
				bean.setId(this.rs.getInt("id"));
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
	public Goods select(int id) {
		Goods bean = null;
		String sql = "select a.*,b.name kname from goods a left join kind b on a.kid=b.id where a.id=?";
		try {
			this.conn = DBUtil.getConnection();
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, id);
			this.rs = this.ps.executeQuery();
			if(rs.next()) {
				bean = new Goods();
				bean.setKname(this.rs.getString("kname"));
				bean.setName(this.rs.getString("name"));
				bean.setAddr(this.rs.getString("addr"));
				bean.setBrand(this.rs.getString("brand"));
				bean.setPrice(this.rs.getFloat("price"));
				bean.setSize(this.rs.getString("size"));
				bean.setInfo(this.rs.getString("info"));
				bean.setId(this.rs.getInt("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		return bean;
	}

}
