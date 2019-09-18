package com.orilore.biz;

import java.util.List;
import java.util.Map;

import com.orilore.model.House;

public interface IHouseBiz {
	public boolean save(House house);
	public boolean remove(int id);
	public House find(int id);
	public List<House> query(Map<String, Object> map);
	public boolean enable(Integer id,Integer status);
}
