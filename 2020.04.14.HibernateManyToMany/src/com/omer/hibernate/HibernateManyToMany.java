package com.omer.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.omer.entity.Kurs;
import com.omer.entity.Ogrenci;
import com.omer.entity.Ogretmen;
import com.omer.entity.OgretmenDetay;

public class HibernateManyToMany {

	public static void main(String[] args) {


		SessionFactory sessionFactory
		= new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Ogretmen.class)
			.addAnnotatedClass(OgretmenDetay.class)
			.addAnnotatedClass(Kurs.class)
			.addAnnotatedClass(Ogrenci.class)
			.buildSessionFactory();
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		

		
		session.beginTransaction();
		//Ogretmen ogr = session.get(Ogretmen.class, 15);
		
		Kurs kurs = session.get(Kurs.class, 15);
		
		Ogrenci ogrenci1 = new Ogrenci("ömer","karakaş",111);
		Ogrenci ogrenci2 = new Ogrenci("ali","can",112);
		
		kurs.addOgrenci(ogrenci1);
		kurs.addOgrenci(ogrenci2);
		
		session.save(kurs);
				
		session.getTransaction().commit();
		session.close();


	}

}
