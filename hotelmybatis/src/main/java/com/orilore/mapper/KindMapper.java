package com.orilore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.orilore.model.Kind;
@Mapper
public interface KindMapper {

	public boolean insert(Kind bean);
	public boolean delete(int id);
	public boolean update(Kind bean);
	public List<Kind> selectAll();
	public List<Kind> select();
	public Kind selectOne(int id);
}
