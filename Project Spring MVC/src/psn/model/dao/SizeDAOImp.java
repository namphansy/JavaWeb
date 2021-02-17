package psn.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import psn.model.entity.Size;

@Repository
public class SizeDAOImp implements SizeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Size> listSizes() {
		Session session = null;
		Transaction transaction = null;
		List<Size> listSizes = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Size.class);
			listSizes = criteria.list();
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		return listSizes;
	}

}
