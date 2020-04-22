package com.omer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omer.dao.OgrenciDAO;
import com.omer.domain.Kurs;
import com.omer.domain.Ogrenci;

@Service
public class OgrenciServisiImpl implements OgrenciServisi {

	@Autowired
	private OgrenciDAO ogrenciDAO;
	
	@Transactional
	@Override
	public List<Ogrenci> getOgrenciler() {
		// TODO Auto-generated method stub
		return ogrenciDAO.getOgrenciler();
	}

	@Transactional
	@Override
	public void saveOgrenci(Ogrenci ogr) {
		// TODO Auto-generated method stub
		//ön kontroller
		if (! ogr.getIsim().equals("Alex"))
			ogrenciDAO.saveOgrenci(ogr);
	}

	@Transactional
	@Override
	public Ogrenci getOgrenci(int ogrId) {
		// TODO Auto-generated method stub
		return ogrenciDAO.getOgrenci(ogrId);
	}

	@Transactional
	@Override
	public void deleteOgrenci(int ogrId) {

		ogrenciDAO.deleteOgrenci(ogrId);
		
	}

	@Transactional
	@Override
	public List<Kurs> getKursList() {
		// TODO Auto-generated method stub
		return ogrenciDAO.getKursList();
	}

}
