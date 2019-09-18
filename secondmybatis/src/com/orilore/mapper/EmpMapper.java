package com.orilore.mapper;

import java.util.List;

import com.orilore.model.Emp;

public interface EmpMapper {
	public boolean insert(Emp bean);
	public boolean delete(int id);
	public boolean update(Emp bean);
	public List<Emp> select();
	public Emp selectOne(int id);
}
