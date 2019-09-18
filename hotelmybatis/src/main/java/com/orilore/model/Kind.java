package com.orilore.model;

import java.util.List;

public class Kind {
	private Integer id;
	private String name;
	private String icon;
	private String info;
	private int status;
	private List<House> houses;
	
	public List<House> getHouses() {
		return houses;
	}
	public void setHouses(List<House> houses) {
		this.houses = houses;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
