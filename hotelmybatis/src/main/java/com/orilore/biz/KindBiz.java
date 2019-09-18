package com.orilore.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.orilore.mapper.KindMapper;
import com.orilore.model.Kind;
@Service
public class KindBiz implements IKindBiz {
	@Resource
	private KindMapper mapper;
	@Override
	public boolean save(Kind kind) {
		if(kind.getId()!=null) {
			return this.mapper.update(kind);
		}else {
			return this.mapper.insert(kind);
		}
 	}

	@Override
	public boolean remove(int id) {

		return this.mapper.delete(id);
	}

	@Override
	public Kind find(int id) {

		return this.mapper.selectOne(id);
	}

	@Override
	public List<Kind> query() {

		return this.mapper.select();
	}

}
