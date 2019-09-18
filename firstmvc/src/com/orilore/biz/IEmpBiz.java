package com.orilore.biz;
import com.orilore.model.*;
import java.util.List;
public interface IEmpBiz{
	public boolean save(Emp emp);
	public boolean remove(Integer id);
	public Emp find(Integer id);
	public List<Emp> query();
}