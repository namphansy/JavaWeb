package psn.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import psn.model.entity.Orders;

@Repository
public class OrderDAOImp implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Orders> listOrders() {
		Session session = null;
		Transaction transaction = null;
		List<Orders> listOrders = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Orders.class);
			listOrders = criteria.list();
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		
		return listOrders;
	}

	@Override
	public boolean updateStatusOrders(Orders orders) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			boolean status = orders.isOrderStatus();
			orders.setOrderStatus(!status);
			
			session.merge(orders);
			check = true;
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		
		return check;
	}

	@Override
	public Orders findById(int ordersId) {
		Session session = null;
		Transaction transaction = null;
		Orders orders = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			orders = (Orders) session.createQuery("from Orders where orderId = :orderId")
					.setParameter("orderId", ordersId).uniqueResult();
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		
		return orders;
	}

}
