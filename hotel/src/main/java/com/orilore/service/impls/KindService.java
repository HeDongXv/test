package com.orilore.service.impls;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.orilore.dao.IKindDAO;
import com.orilore.model.Kind;
import com.orilore.service.IKindService;

@Service
public class KindService implements IKindService {
	@Resource
	private IKindDAO dao;
	@Override
	public boolean save(Kind bean) {
		if(bean.getId()>0) {
			return this.dao.update(bean);
		}else {
			return this.dao.insert(bean);
		}

	}

	@Override
	public boolean remove(int id) {

		return this.dao.delete(id);
	}

	@Override
	public List<Kind> query() {

		return this.dao.select();
	}

	@Override
	public Kind find(int id) {

		return this.dao.select(id);
	}

}
