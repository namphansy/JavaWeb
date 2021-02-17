package psn.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import psn.model.entity.Color;

@Repository
public class ColorDAOImp implements ColorDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Color> listColor() {
		Session session = null;
		Transaction transaction = null;
		List<Color> listColor = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Color.class);
			listColor = criteria.list();
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		return listColor;
	}

	@Override
	public Color findById(int colorId) {
		Session session = null;
		Transaction transaction = null;
		Color color = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			color = (Color) session.createQuery("from Color where colorId = :colorId")
					.setParameter("colorId", colorId);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		return color;
	}

}
