package com.orilore.model;

import java.util.List;

public class Dept{
	private Integer id;
	private String name;
	private String addr;
	private List<Emp> emps;
		
	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public void setId(Integer id){
		this.id=id;	}

	public Integer getId(){
		return this.id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	public void setAddr(String addr){
		this.addr=addr;
	}
	public String getAddr(){
		return this.addr;
	}
}