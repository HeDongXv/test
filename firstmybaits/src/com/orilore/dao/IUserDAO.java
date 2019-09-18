package com.orilore.dao;

import java.util.List;

import com.orilore.model.User;

public interface IUserDAO {

	public boolean insert(User bean);
	public boolean delete(int id);
	public boolean update(User bean);
	public User selectOne(int id);
	public List<User> select();
}
