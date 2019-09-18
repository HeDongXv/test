package com.orilore.biz;

import java.util.List;

import com.orilore.model.Kind;

public interface IKindBiz {

	public boolean save(Kind kind);
	public boolean remove(int id);
	public Kind find(int id);
	public List<Kind> query();
}
