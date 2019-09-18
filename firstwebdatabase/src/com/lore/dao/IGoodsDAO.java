package com.lore.dao;

import java.util.List;

import com.lore.model.Goods;

public interface IGoodsDAO {

	public boolean insert(Goods bean);
	public boolean delete(int id);
	public boolean update(Goods bean);
	public List<Goods> select();
	public Goods select(int id);
	public void close();
}
