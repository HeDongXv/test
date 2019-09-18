package com.orilore.biz;
import com.orilore.model.*;
import com.orilore.db.DBUtil;
import com.orilore.mapper.*;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
public class DeptBiz implements IDeptBiz{
	private SqlSession session = null;
	private DeptMapper mapper  = null;

	@Override
	public boolean save(Dept bean) {
		try {
			session = DBUtil.getSession();
			mapper = session.getMapper(DeptMapper.class);
			if(bean.getId()!=null){
				this.mapper.update(bean);
			}else{
				this.mapper.insert(bean);
			}
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			session.close();
		}
	}

	@Override
	public boolean remove(Integer id) {
		try {
			session = DBUtil.getSession();
			mapper = session.getMapper(DeptMapper.class);
			mapper.delete(id);
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return this.mapper.delete(id);
	}

	@Override
	public Dept find(Integer id) {
		Dept bean = null;
		try {
			session = DBUtil.getSession();
			mapper = session.getMapper(DeptMapper.class);
			bean = mapper.selectOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return bean;
	}

	@Override
	public List<Dept> query() {
		List<Dept> beans = null;
		try {
			session = DBUtil.getSession();
			mapper = session.getMapper(DeptMapper.class);
			beans = mapper.select();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
				
		return beans;
	}
}
