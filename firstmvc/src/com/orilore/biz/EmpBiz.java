package com.orilore.biz;
import com.orilore.model.*;
import com.orilore.db.DBUtil;
import com.orilore.mapper.*;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
public class EmpBiz implements IEmpBiz{
	private SqlSession session = null;
	private EmpMapper mapper  = null;

	@Override
	public boolean save(Emp bean) {
		try {
			session = DBUtil.getSession();
			mapper = session.getMapper(EmpMapper.class);
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
			mapper = session.getMapper(EmpMapper.class);
			mapper.delete(id);
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
	public Emp find(Integer id) {
		Emp bean = null;
		try {
			session = DBUtil.getSession();
			mapper = session.getMapper(EmpMapper.class);
			bean = mapper.selectOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return bean;
	}

	@Override
	public List<Emp> query() {
		List<Emp> beans = null;
		try {
			session = DBUtil.getSession();
			mapper = session.getMapper(EmpMapper.class);
			beans = mapper.select();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
				
		return beans;
	}
}
