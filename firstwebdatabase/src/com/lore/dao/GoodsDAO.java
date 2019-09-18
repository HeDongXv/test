package com.lore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lore.db.DBUtil;
import com.lore.model.Goods;

/**
 * 商品信息数据访问对象
 * @author he
 *
 */
public class GoodsDAO implements IGoodsDAO{
	//数据库连接对象
	private Connection conn;
	//sql语句执行器
	private PreparedStatement ps;
	//结果集
	private ResultSet rs;
	//关闭,必须捕获异常
	public void close() {
		try {
			if(this.rs!=null)this.rs.close();
			if(this.ps!=null)this.ps.close();
			if(this.conn!=null && !this.conn.isClosed())this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除商品信息的方法
	 *  @param int id
	 * @return boolean
	 */
	public boolean delete(int id) {
		String sql = "delete from goods where id=?";
		boolean flag = false;
		try {
			this.conn = DBUtil.getConnector();
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, id);
			if(this.ps.executeUpdate()>0) {
				flag=true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			this.close();
		}
		return flag;
	}
	
	/**
	 * 查询一条商品信息的方法
	 * @param int id
	 * @return Goods bean
	 */
	public Goods select(int id) {
		Goods bean = null;
		String sql = "select a.*,b.name kname from goods a left join kind b on a.kid=b.id where a.id=?";
		try {
			this.conn = DBUtil.getConnector();
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, id);
			this.rs = this.ps.executeQuery();
						
			if(this.rs.next()) {
				bean = new Goods();
				bean.setKname(this.rs.getString("kname"));
				bean.setName(this.rs.getString("name"));
				bean.setSize(this.rs.getString("size"));
				bean.setBrand(this.rs.getString("brand"));
				bean.setInfo(this.rs.getString("info"));
				bean.setPrice(this.rs.getFloat("price"));
				bean.setAddr(this.rs.getString("addr"));
				bean.setId(this.rs.getInt("id"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			this.close();
		}
		return bean;
	} 
	
	/**
	 *  查询商品信息的方法
	 * @return List<Goods>
	 */
	public List<Goods> select() {
		String sql = "select a.*,b.name kname from goods a left join kind b on a.kid=b.id order by id desc";
		List<Goods> list = new ArrayList<Goods>();
		try {
			this.conn = DBUtil.getConnector();
			this.ps = this.conn.prepareStatement(sql);
			this.rs = this.ps.executeQuery();
			
			while(this.rs.next()) {
				Goods bean = new Goods();
				bean.setKname(this.rs.getString("kname"));
				bean.setName(this.rs.getString("name"));
				bean.setSize(this.rs.getString("size"));
				bean.setBrand(this.rs.getString("brand"));
				bean.setInfo(this.rs.getString("info"));
				bean.setPrice(this.rs.getFloat("price"));
				bean.setAddr(this.rs.getString("addr"));
				bean.setId(this.rs.getInt("id"));
				list.add(bean);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			this.close();
		}
		return list;
	}

	/**
	 * 项商品信息表中添加一条新记录
	 * @param Goods bean
	 * @return boolean
	 */
	public boolean insert(Goods bean) {
		boolean flag=false;
		String sql= "insert into goods(name,kid,price,size,brand,addr,info) values(?,?,?,?,?,?,?)";
		try {
			this.conn=DBUtil.getConnector();
			this.ps=conn.prepareStatement(sql);
			//数字代表问号
			this.ps.setString(1,bean.getName());
			this.ps.setInt(2,bean.getKid());
			this.ps.setFloat(3,bean.getPrice());
			this.ps.setString(4,bean.getSize());
			this.ps.setString(5,bean.getBrand());
			this.ps.setString(6,bean.getAddr());
			this.ps.setString(7,bean.getInfo());
			//执行
			if(ps.executeUpdate()>0) {
				flag=true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		return flag;
	}

	
	/**
	 * 修改商品信息的方法
	 * @param Goods bean
	 * @return boolean
	 */
	@Override
	public boolean update(Goods bean) {
		String sql = "update goods set name=?,size=?,price=?,brand=?,addr=?,info=?,kid=? where id=?";
		boolean flag = false;
		try {
			this.conn = DBUtil.getConnector();
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
				flag =true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			this.close();
		}
		return flag;
	}
}
//	public static void main(String[] args) {
//
//		GoodsDAO dao=new GoodsDAO();
//		Goods bean = new Goods();
//		bean.setAddr("韩国");
//		bean.setBrand("三星");
//		bean.setInfo("摄像，屏幕，尺寸");
//		bean.setKid(7);
//		bean.setName("Note10");
//		bean.setPrice(6500);
//		bean.setSize("128G");
//		boolean f=dao.insert(bean);
//		System.out.println(f); 
//	}
	
	
	/*public static void main(String[] args) {
		GoodsDAO dao = new GoodsDAO();
		List<Goods> list = dao.select();
		for(Goods g:list) {
			System.out.println(g.getId());
		}
	}*/


