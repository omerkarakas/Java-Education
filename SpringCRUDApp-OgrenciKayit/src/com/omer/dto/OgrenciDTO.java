package com.omer.dto;

import java.util.List;

import com.omer.domain.Kurs;
import com.omer.domain.Ogrenci;

public class OgrenciDTO {

	private Ogrenci ogrenci;
	
	private List<Kurs> kurslar;

	public Ogrenci getOgrenci() {
		return ogrenci;
	}

	public void setOgrenci(Ogrenci ogrenci) {
		this.ogrenci = ogrenci;
	}

	public List<Kurs> getKurslar() {
		return kurslar;
	}

	public void setKurslar(List<Kurs> kurslar) {
		this.kurslar = kurslar;
	}

	public OgrenciDTO(Ogrenci ogrenci, List<Kurs> kurslar) {
		super();
		this.ogrenci = ogrenci;
		this.kurslar = kurslar;
	}
	
	
}
