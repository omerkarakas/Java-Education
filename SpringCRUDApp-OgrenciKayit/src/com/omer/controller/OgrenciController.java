package com.omer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.omer.dao.OgrenciDAO;
import com.omer.domain.Kurs;
import com.omer.domain.Ogrenci;
import com.omer.dto.OgrenciDTO;
import com.omer.service.OgrenciServisi;

@Controller
@RequestMapping("/ogrenci")
public class OgrenciController {

	@Autowired
	OgrenciServisi ogrenciServisi;

	@GetMapping("/list") // sayfa geçişleri için
	public String listOgrenci(Model model) {

		List<Ogrenci> ogrList = ogrenciServisi.getOgrenciler();

		model.addAttribute("ogrenciler", ogrList);

		return "ogrenci-list";
	}

	@GetMapping("/ogrenci-ekle")
	public String ogrenciEkle(Model model) {

		Ogrenci ogr = new Ogrenci();
		
		/* OgrenciDTO ogrDto = new 
				OgrenciDTO(ogr,ogrenciServisi.getKursList()); */
		model.addAttribute("ogrenci", ogr);

		return "ogrenci-form";
	}

	@GetMapping("/ogrenci-guncelle")
	public String ogrenciGuncelle(@RequestParam("ogrenciId") int ogrId, Model model) {

		Ogrenci ogr = ogrenciServisi.getOgrenci(ogrId);

		model.addAttribute("ogrenci", ogr);

		return "ogrenci-form";
	}

	@GetMapping("/ogrenci-sil")
	public String ogrenciSil(@RequestParam("ogrenciId") int ogrId) {

		ogrenciServisi.deleteOgrenci(ogrId);

		return "redirect:/ogrenci/list";
	}

	@PostMapping("/ogrenci-kaydet")
	public String ogrenciKaydet(@ModelAttribute("ogrenci") Ogrenci ogr) {

		ogrenciServisi.saveOgrenci(ogr);
		return "redirect:/ogrenci/list";
	}

	@ModelAttribute("kurslar")
	public Map<Integer, String> getKurslar() {
		Map<Integer, String> kurslar = new HashMap<Integer, String>();

		List<Kurs> kursList = ogrenciServisi.getKursList();
		for (Kurs kurs : kursList) {
			kurslar.put(kurs.getId(), kurs.getKursAdi());
		}

		return kurslar;
	}

}
