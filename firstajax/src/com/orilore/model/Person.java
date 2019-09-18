package com.orilore.model;

public class Person {

	private String name;
	private String sex;
	private int age;
	private String addr;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Person() {
		super();
		
	}
	public Person(String name, String sex, int age, String addr) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.addr = addr;
	}
}
