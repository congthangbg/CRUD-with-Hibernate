package edu.poly.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	private static Session session;
	
	public static SessionFactory getSessionFactory() {
		if(factory == null || !factory.isOpen()) {
			//Khởi tạo lại
			Configuration config=new Configuration();
			config.configure("hibernate.cfg.xml");
			
			factory= config.buildSessionFactory();//trả về 1 factory
		}
		return factory;
	}
	
	public static Session getSession() {
		if(session ==null || !session.isOpen()) {
			session=getSessionFactory().openSession();
		}
		
		return session;
	}
}
