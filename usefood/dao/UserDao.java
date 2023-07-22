package org.jsp.usefood.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.usefood.dto.FOrder;
import org.jsp.usefood.dto.User;

public class UserDao {
	EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();

	public User saveUser(User u) {
		EntityTransaction t = m.getTransaction();
		m.persist(u);
		t.begin();
		t.commit();
		return u;
	}
	public User updateUser(User u) {
		EntityTransaction t=m.getTransaction();
		m.merge(u);
		t.begin();
		t.commit();
		return u;
	}

	public User verifyUser(String email, String password) {
		String qry = "select u from  User u where u.email=?1 and u.password=?2";
		Query q = m.createQuery(qry);
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}
	
	
	
	
	
}
