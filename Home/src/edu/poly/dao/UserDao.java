package edu.poly.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import edu.poly.entity.User;
import edu.poly.utils.HibernateUtils;

public class UserDao {
	
	public User store(User user) {
		Session session=HibernateUtils.getSession();
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return user;
	}
	public List<User> Paginate(int offset,int limit){
		Session session=HibernateUtils.getSession();
		String hql="FROM User";
		Query query=session.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(limit+ offset);
		
		List<User> list=query.getResultList();
		return list;
	}
	public User findById(int id) {
		Session session=HibernateUtils.getSession();
		User user=session.find(User.class, id);
		
		return user;
	}
	public void update(User user) {
		Session session=HibernateUtils.getSession();
		try {
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			throw e;
		}finally {
			session.close();
		}
	}
	public void delete(int id) {
		Session session=HibernateUtils.getSession();
		try {
			session.beginTransaction();
			User user=session.find(User.class, id);
			if(user != null) {
				session.delete(user);
			}
			else {
				throw new Exception("User can not found");	
			}
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
	}
}
