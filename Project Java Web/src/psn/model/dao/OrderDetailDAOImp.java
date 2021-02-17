package psn.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import psn.model.entity.OrderDetail;

@Repository
public class OrderDetailDAOImp implements OrderDetailDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<OrderDetail> listOrderDetail() {
		Session session = null;
		Transaction transaction = null;
		List<OrderDetail> listOrderDetail = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(OrderDetail.class);
			listOrderDetail = criteria.list();
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		
		return listOrderDetail;
	}

	@Override
	public List<OrderDetail> listByOrderId(int orderId) {
		Session session = null;
		Transaction transaction = null;
		List<OrderDetail> listByOrderId = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			String query = "Select od From OrderDetail od where orders.orderId = :id";
			
			listByOrderId = session.createQuery(query, OrderDetail.class).
					setParameter("id", orderId).list();
					
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		
		return listByOrderId;
	}
	
}
