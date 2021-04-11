package edu.poly.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

import edu.poly.entity.User;
import edu.poly.entity.Video;
import edu.poly.utils.HibernateUtils;

public class VideoDao extends AbstractEntityDao<Video>{

	public VideoDao() {
		super(Video.class);
	
	}
	public List<Video> findPaga(int offset,int limit){
		Session session=HibernateUtils.getSession();
		try {
			String hql="FROM Video";
			Query query=session.createQuery(hql);
			query.setFirstResult(offset);
			query.setMaxResults(limit);
			List<Video> list=query.getResultList();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			throw e;
		}
	}
	public List<Video> findAll(){
		Session session=HibernateUtils.getSession();
		String hql="FROM Video";
		TypedQuery<Video> query=session.createQuery(hql,Video.class);
		
		return query.getResultList();
		
	}
}
