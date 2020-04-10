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
		
		
		session.beginTransaction();
		
		OgretmenDetay ogrDty = 
				session.get(OgretmenDetay.class, 1);
		
				
		session.getTransaction().commit();
		
		session.close();

		System.out.println(ogrDty);
    	System.out.println(ogrDty.getOgretmen());

	}

}
