package psn.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import psn.model.entity.Material;

@Repository
public class MaterialDAOImp implements MaterialDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Material> listMaterial() {
		Session session = null;
		Transaction transaction = null;
		List<Material> listMaterial = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Material.class);
			
			listMaterial = criteria.list();
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		
		return listMaterial;
	}

}
