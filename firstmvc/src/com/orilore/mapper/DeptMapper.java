package com.orilore.mapper;
import java.util.List;
import com.orilore.model.*;
public interface DeptMapper{
	public boolean insert(Dept bean);
	public Dept selectOne(Integer id);
	public boolean delete(Integer id);
	public List<Dept> select();
	public boolean update(Dept bean);
}