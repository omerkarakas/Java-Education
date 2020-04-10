package com.omer.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omer.entity.Ogretmen;
import com.omer.entity.OgretmenDetay;

public class HibernateOneToOne {

	public static void main(String[] args) {


		SessionFactory sessionFactory
		= new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Ogretmen.class)
			.addAnnotatedClass(OgretmenDetay.class)
			.buildSessionFactory();
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		OgretmenDetay ogrDty = new OgretmenDetay("java", "sinema", "http://google4.com", "http://fb.me/omer");
		
		Ogretmen ogr = new Ogretmen(ogrDty,"Ömer","Karakaş","omerkarakas6@hotmail");

		session.beginTransaction();
		
		//session.save(ogrDty);
		session.save(ogr);
					
		session.getTransaction().commit();
		
		session.close();
	}

}
