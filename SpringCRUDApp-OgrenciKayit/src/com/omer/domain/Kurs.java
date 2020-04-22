package com.omer.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.omer.service.OgrenciServisi;

@Entity
@Table(name="KURS")
public class Kurs {

	
	@Id
	@Column(name="Id")
	private int id;
	
	@Column(name="kurs_adi")
	private String kursAdi;
	
	@Column(name="saat")
	private int saat;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKursAdi() {
		return kursAdi;
	}

	public void setKursAdi(String kursAdi) {
		this.kursAdi = kursAdi;
	}

	public int getSaat() {
		return saat;
	}

	public void setSaat(int saat) {
		this.saat = saat;
	}

	public Kurs() {
		super();
	}

	@Override
	public String toString() {
		return kursAdi;
	}
	
	
}
