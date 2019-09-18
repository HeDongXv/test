package com.orilore.mapper;

import java.util.List;

import com.orilore.model.Dept;

public interface DeptMapper {
	public boolean insert(Dept bean);
	public boolean delete(int id);
	public boolean update(Dept bean);
	public List<Dept> select();
	public Dept selectOne(int id);
	
}
