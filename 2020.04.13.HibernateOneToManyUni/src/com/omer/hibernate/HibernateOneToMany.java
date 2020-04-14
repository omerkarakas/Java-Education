package com.omer.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omer.entity.Konu;
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
			.addAnnotatedClass(Konu.class)
			.buildSessionFactory();
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		
		
		
		session.beginTransaction();
		Ogretmen ogr = session.get(Ogretmen.class, 13);
		
		Kurs kurs = new Kurs("JEE",600,ogr);
		
		kurs.addKonu(new Konu("Basics","Kontroller, Döngüler..."));
		kurs.addKonu(new Konu("OOP","Inheritance, Polimorfizm..."));
		kurs.addKonu(new Konu("Threads","Thread, Runnable..."));
				
		session.save(kurs);
				
		session.getTransaction().commit();
		session.close();


	}

}
