package com.orilore.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.orilore.mapper.DeptMapper;
import com.orilore.mapper.EmpMapper;
import com.orilore.model.Dept;
import com.orilore.model.Emp;

public class Test {

	public static void main(String[] args) {
		SqlSession session = DBUtil.getSession();
		DeptMapper mapper = session.getMapper(DeptMapper.class);
		EmpMapper empmapper = session.getMapper(EmpMapper.class);
		
		List<Dept> depts = mapper.select();
		if(depts!=null) {
			for(Dept d:depts) {
				System.out.println(d.getName()+"\t"+d.getAddr());
				System.out.println("----------------");
				List<Emp> emps = d.getEmps();
				if(emps!=null) {
					for(Emp e:emps) {
						System.out.println(e.getName()+" "+e.getBirthday()+" "+e.getJob());
					}
				}
			}
		}
//		System.out.println(dept.getName()+" "+dept.getAddr());
//		System.out.println("-----------------------------");
		
//		List<Emp> list = empmapper.select();
//		for(Emp e:list) {
//			System.out.println(e.getName()+e.getDept().getName());
//		}
	} 

}
