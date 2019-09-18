package com.orilore.service;

import java.util.List;

import com.orilore.model.Kind;

public interface IKindService {

	public boolean save(Kind bean);
	public boolean remove(int id);
	public List<Kind> query();
	public Kind find(int id);
}
