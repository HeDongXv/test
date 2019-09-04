package com.orilore.dao;

import java.util.List;

import com.orilore.entity.Area;

public interface IAreaDAO {
	public void close();
	public boolean insert(Area area);
	public boolean delete(int id);
	public boolean update(Area area);
	public List<Area> select(Integer cid);
	public Area selectOne(int id);
}
