package edu.poly.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import edu.poly.utils.HibernateUtils;

public abstract class AbstractEntityDao<T> {
	public Class<T> entityClass;

	public AbstractEntityDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	public void insert(T entity) {
		Session session=HibernateUtils.getSession();
		try {
			session.clear();
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			throw e;
		}
	}
	public void update(T entity) {
		Session session=HibernateUtils.getSession();
		try {
			session.clear();
			session.beginTransaction();
			session.update(entity);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			throw e;
		}
	}
	public void delete(T entity) {
		Session session=HibernateUtils.getSession();
		try {
			session.clear();
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			throw e;
		}
	}
	public T findById(Object id) {
		Session session=HibernateUtils.getSession();
		T entity=session.find(entityClass, id);
		
		return entity;
	}
}
