package edu.poly.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sessionFactory;
	private static Session session;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null || !sessionFactory.isOpen()) {
			Configuration config=new Configuration();
			config.configure("hibernate.cfg.xml");
			
			sessionFactory=config.buildSessionFactory();
		}
		return sessionFactory;
	}
	public static Session getSession() {
		if(session == null || !session.isOpen()) {
			session=getSessionFactory().openSession();
		}
		return session;
	}
	
}
