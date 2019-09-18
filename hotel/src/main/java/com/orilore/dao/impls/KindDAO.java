package com.orilore.dao.impls;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.orilore.dao.IKindDAO;
import com.orilore.model.Kind;

@Repository
public class KindDAO implements IKindDAO {

	@Resource
	private JdbcTemplate temp;
	
	@Override
	public boolean insert(Kind bean) {
		String sql = "insert into kind(name,icon,info) values(?,?,?)";
		int n = temp.update(sql,bean.getName(),bean.getIcon(),bean.getInfo());
		if(n>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean update(Kind bean) {
		String sql = "update kind set name=?,icon=?,info=? where id=?";
		int n = temp.update(sql,bean.getName(),bean.getIcon(),bean.getInfo(),bean.getId());
		if(n>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		String sql = "update kind set status=-1 where id=?";
		int n = temp.update(sql,id);
		if(n>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Kind> select() {
		String sql = "select * from kind where status!=-1";
		//object用于带参查询
		List<Kind> list = temp.query(sql,new Object[] {},new BeanPropertyRowMapper<Kind>(Kind.class));
		return list;
	}
	
	@Override
	public Kind select(int id) {
		String sql = "select * from kind where status!=-1 and id=?";
		//object用于带参查询
		List<Kind> list = temp.query(sql,new Object[] {id},new BeanPropertyRowMapper<Kind>(Kind.class));
		if(list!=null && list.size()>0) {
			return list.get(0);
		}else {
			
			return null;
		}
	}

}
