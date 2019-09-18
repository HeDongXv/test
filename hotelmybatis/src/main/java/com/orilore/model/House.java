package com.orilore.model;

public class House {
	private int id;
	private String hname;
	private int size;
	private int beds;
	private float price;
	private float dis;
	private String info;
	private String pica;
	private String picb;
	private String picc;
	private int status;
	private Kind kind;
	
	public Kind getKind() {
		return kind;
	}
	public void setKind(Kind kind) {
		this.kind = kind;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getBeds() {
		return beds;
	}
	public void setBeds(int beds) {
		this.beds = beds;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getDis() {
		return dis;
	}
	public void setDis(float dis) {
		this.dis = dis;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getPica() {
		return pica;
	}
	public void setPica(String pica) {
		this.pica = pica;
	}
	public String getPicb() {
		return picb;
	}
	public void setPicb(String picb) {
		this.picb = picb;
	}
	public String getPicc() {
		return picc;
	}
	public void setPicc(String picc) {
		this.picc = picc;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
