package org.spring11.hibernate.dal;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.spring11.hibernate.dal.entity.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HibernateSpitterRepository implements SpitterRepository {
	private SessionFactory sessionFactory;

	@Autowired
	public HibernateSpitterRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	private List<Spitter> findAll() {
		return (List<Spitter>) currentSession().createCriteria(Spitter.class).list();
	}

	@Transactional
	public Spitter save(Spitter spitter) {
		Session session = currentSession();
		Serializable id = session.save(spitter);
		return new Spitter((Integer)id, spitter.getUsername(), spitter.getPassword(), spitter.getFirstName(),
				spitter.getLastName());
	}

	public Spitter findByUsername(String username) {
		return (Spitter) currentSession().createCriteria(Spitter.class).add(Restrictions.eq("username", username))
				.list().get(0);
	}

	public Spitter findOne(int id) {
		return (Spitter) currentSession().get(Spitter.class, id);
	}
}
