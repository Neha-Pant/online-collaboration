package org.socialnetworking.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.socialnetworking.dao.*;
import org.socialnetworking.model.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Repository("eventDAO")
@Transactional
@EnableTransactionManagement
public class EventDAOImpl implements IEventDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public EventDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean addEvent(Event e) {
		try {
			sessionFactory.getCurrentSession().persist(e);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean saveOrUpdate(Event event) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(event);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(Event event) {
		try {
			sessionFactory.getCurrentSession().delete(event);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Event get(int id) {
		String hql = "from Event where id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("id", id);
		try {
			return (Event) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
	}

	public List<Event> list() {
		//String hql = "from Event";
		System.out.println("Event :"+sessionFactory.getCurrentSession().createQuery("FROM Event", Event.class).getResultList());
		//return sessionFactory.getCurrentSession().createQuery(hql).list();
		return sessionFactory.getCurrentSession().createQuery("FROM Event", Event.class).getResultList();
	}

}

