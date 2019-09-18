package com.orilore.model;
public class Emp{
	private Integer id;
	private String name;
	private String sex;
	private String birthday;
	private Dept dept;
	
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public void setId(Integer id){		this.id=id;
	}

	public Integer getId(){
		return this.id;
	}
	public void setName(String name){
		this.name=name;	}

	public String getName(){
		return this.name;
	}
	public void setSex(String sex){
		this.sex=sex;
	}
	public String getSex(){
		return this.sex;
	}
	public void setBirthday(String birthday){
		this.birthday=birthday;
	}
	public String getBirthday(){
		return this.birthday;
	}
	private String phone;
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return this.phone;
	}
	private String addr;
	public void setAddr(String addr){
		this.addr=addr;
	}
	public String getAddr(){
		return this.addr;
	}
	private String job;
	public void setJob(String job){
		this.job=job;
	}
	public String getJob(){
		return this.job;
	}
	private String photo;
	public void setPhoto(String photo){
		this.photo=photo;
	}
	public String getPhoto(){
		return this.photo;
	}
	private Integer status;
	public void setStatus(Integer status){
		this.status=status;
	}
	public Integer getStatus(){
		return this.status;
	}
	
}