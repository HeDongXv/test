package com.orilore.dao;

import java.util.List;

import com.orilore.model.Kind;

public interface IKindDAO {

	public void close();
	public boolean insert(Kind bean);
	public boolean update(Kind bean);
	public boolean delete(int id);
	public List<Kind> select();
	public Kind selectOne(int id);
}
