package com.omer.aopdemo.domain;

import org.springframework.stereotype.Component;

@Component
public class Student {

	private String isim;
	private String soyisim;
	private int id;

	public String getIsim() {
		System.out.println("getIsim...");
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		System.out.println("getSoyisim...");
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public Student() {
		this.isim = "default isim";
		this.soyisim = "default soyisim";
		this.id = 100;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
