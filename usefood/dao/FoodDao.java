package org.jsp.usefood.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.usefood.dto.FOrder;
import org.jsp.usefood.dto.User;

public class FoodDao {
	EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();

	public FOrder saveFoodOrder(FOrder o, int order_id) {
		User u = m.find(User.class, order_id);
		if (u != null) {
			o.setUsr(u);// Assigning user for order
			u.getOrders().add(o);
			EntityTransaction t = m.getTransaction();
			m.persist(o);
			t.begin();
			t.commit();
			return o;

		}
		return null;
	}

	public FOrder updateFoodOrder(FOrder o, int order_id) {
		User u = m.find(User.class, order_id);
		if (u != null) {
			o.setUsr(u);// Assigning user for order
			u.getOrders().add(o);
			EntityTransaction t = m.getTransaction();
			m.merge(o);
			t.begin();
			t.commit();
			return o;
		}
		return null;
	}

	public List<FOrder> fetchOrderById(int order_id) {
		String qry = "select u.orders from User u where u.id=?1";
		Query q = m.createQuery(qry);
		q.setParameter(1, order_id);
		return q.getResultList();

	}

	public List<FOrder> fetchOrderByEmailPassword(String email, String password) {
		String qry = "select u.orders from User u where u.email=?1 and u.password=?2";
		Query q = m.createQuery(qry);
		q.setParameter(1, email);
		q.setParameter(2, password);

		return q.getResultList();

	}

	public FOrder deleteFoodOrder(FOrder o, int order_id) {
		FOrder f = m.find(FOrder.class, order_id);
		if (f != null) {
			EntityTransaction t = m.getTransaction();
			m.remove(f);
			t.begin();
			t.commit();
			return f;
		}
		return null;
	
	}
}
