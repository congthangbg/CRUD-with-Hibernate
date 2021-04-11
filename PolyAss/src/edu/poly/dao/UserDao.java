package edu.poly.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

import edu.poly.entity.User;
import edu.poly.utils.HibernateUtils;

public class UserDao extends AbstractEntityDao<User>{

	public UserDao() {
		super(User.class);
	
	}
	public List<User> findAll(int offset,int limit){
		Session session=HibernateUtils.getSession();
		String hql="FROM User";
		Query query=session.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(limit );
		
		List<User> list=query.getResultList();
		return list;
	}
	public List<User> findAll2(){
		Session session=HibernateUtils.getSession();
		String hql="FROM User";
		TypedQuery<User> query=session.createQuery(hql,User.class);
		
		return query.getResultList();
		
	}
}
