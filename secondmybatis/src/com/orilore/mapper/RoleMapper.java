package com.orilore.mapper;

import java.util.List;

import com.orilore.model.Role;

public interface RoleMapper {
	public boolean insert(Role bean);
	public boolean delete(int id);
	public boolean update(Role bean);
	public List<Role> select();
	public Role selectOne(int id);
}
