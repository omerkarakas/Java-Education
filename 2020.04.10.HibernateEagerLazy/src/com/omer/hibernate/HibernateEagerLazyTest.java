package com.omer.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omer.entity.Kurs;
import com.omer.entity.Ogretmen;
import com.omer.entity.OgretmenDetay;

public class HibernateEagerLazyTest {

	public static void main(String[] args) {


		SessionFactory sessionFactory
		= new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Ogretmen.class)
			.addAnnotatedClass(OgretmenDetay.class)
			.addAnnotatedClass(Kurs.class)
			.buildSessionFactory();
		
	/*	Ogretmen ogr = new Ogretmen(null, "Muhammed", "Salih", "salih@gmail");
		
		ogr.setOgretmenDetay(new OgretmenDetay("java", "hobi", "www.abc.com", "fb.com"));
		
		ogr.addKurs(new Kurs("Java3",500,ogr));
		ogr.addKurs(new Kurs("DB3",250,null));
		ogr.addKurs(new Kurs("WebMobil2",100,null));
		ogr.addKurs(new Kurs("Design Patterns2",100,null));
		*/

		//create session
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		Ogretmen salih = session.get(Ogretmen.class, 15);
		salih.getKurslar().size();

		
		session.getTransaction().commit();
		session.close();
		
		System.out.println(salih);
		System.out.println(salih.getKurslar());		

	

	}

}
