package com.omer.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omer.entity.Kurs;
import com.omer.entity.Ogretmen;
import com.omer.entity.OgretmenDetay;

public class HibernateOneToMany {

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
		
		
		Ogretmen ogr = new Ogretmen(null, "Ali", "Can", "alican@gmail");
		
		ogr.addKurs(new Kurs("Java",600,ogr));
		ogr.addKurs(new Kurs("DB",300,null));
		ogr.addKurs(new Kurs("Web",200,null));
		

		session.beginTransaction();
		
		session.save(ogr);
				
		session.getTransaction().commit();
		session.close();


	}

}
