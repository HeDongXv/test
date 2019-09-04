package com.orilore.dao;

import java.sql.Connection;
import java.util.List;

import com.orilore.entity.Area;
import com.orilore.entity.City;

public interface ICityDAO {
	public void close();
	public boolean insert(City city);
	public boolean delete(int id);
	public boolean update(City city);
	public List<City> select();
	public City selectOne(int id);
}
