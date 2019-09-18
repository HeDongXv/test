package com.orilore.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.orilore.mapper.HouseMapper;
import com.orilore.model.House;
@Service
public class HouseBiz implements IHouseBiz{
@Resource
	private HouseMapper mapper;
	@Override
	public boolean save(House house) {
		if(house.getId()>0) {
			return this.mapper.update(house);
		}else {
			return this.mapper.insert(house);
		}
	}

	@Override
	public boolean remove(int id) {
		
		return this.mapper.delete(id);
	}

	@Override
	public House find(int id) {
		
		return this.mapper.selectOne(id);
	}

	@Override
	public List<House> query(Map<String, Object> map) {
		
		return this.mapper.select(map);
	}

	@Override
	public boolean enable(Integer id, Integer status) {
		House bean = new House();
		bean.setId(id);
		bean.setStatus(status);
		return this.mapper.enable(bean);
	}

}
