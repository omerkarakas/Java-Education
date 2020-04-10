package com.omer.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omer.entity.Kurs;
import com.omer.entity.Ogretmen;
import com.omer.entity.OgretmenDetay;

public class HibernateOneToManyDML {

	public static void main(String[] args) {


		SessionFactory sessionFactory
		= new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Ogretmen.class)
			.addAnnotatedClass(OgretmenDetay.class)
			.addAnnotatedClass(Kurs.class)
			.buildSessionFactory();
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		

		session.beginTransaction();
		
		Ogretmen ogr = session.get(Ogretmen.class, 11);
		
		
		Kurs k = ogr.getKurslar().get(0);
		ogr.getKurslar().remove(0);
		session.remove(k);
		
		
		Kurs k2 = ogr.getKurslar().get(0);
		k2.setKursAdi("DB4");
		session.save(k2);

		
		session.save(ogr);
				
		session.getTransaction().commit();
		session.close();


	}

}
