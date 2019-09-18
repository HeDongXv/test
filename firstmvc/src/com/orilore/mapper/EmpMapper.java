package com.orilore.mapper;
import java.util.List;
import com.orilore.model.*;
public interface EmpMapper{
	public boolean insert(Emp bean);
	public Emp selectOne(Integer id);
	public boolean delete(Integer id);
	public List<Emp> select();
	public boolean update(Emp bean);
}