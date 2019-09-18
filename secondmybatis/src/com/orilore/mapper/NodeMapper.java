package com.orilore.mapper;

import java.util.List;

import com.orilore.model.Node;

public interface NodeMapper {
	public boolean insert(Node bean);
	public boolean delete(int id);
	public boolean update(Node bean);
	public List<Node> select();
	public Node selectOne(int id);
}
