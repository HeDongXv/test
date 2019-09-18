package com.orilore.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.orilore.model.House;
@Mapper
public interface HouseMapper {

	public boolean insert(House bean);
	public boolean delete(int id);
	public boolean update(House bean);
	public boolean enable(House bean);
	public House selectOne(int id);
	//分组查询
	public List<House> select(Map<String, Object> map);
}
