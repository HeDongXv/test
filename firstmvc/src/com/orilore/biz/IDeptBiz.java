package com.orilore.biz;
import com.orilore.model.*;
import java.util.List;
public interface IDeptBiz{
	public boolean save(Dept dept);
	public boolean remove(Integer id);
	public Dept find(Integer id);
	public List<Dept> query();
}