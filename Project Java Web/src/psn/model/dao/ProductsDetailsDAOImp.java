package psn.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import psn.model.entity.ProductsDetails;

@Repository
public class ProductsDetailsDAOImp implements ProductsDetailsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<ProductsDetails> getAllProductDetails(){
		Session session = null;
		Transaction transaction = null;
		List<ProductsDetails> listProductDetails = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(ProductsDetails.class);
			listProductDetails = criteria.list();
			
			transaction.commit();
					
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return listProductDetails;
	}
	
	@Override
	public ProductsDetails findById(int productDetailsId) {
		Session session = null;
		Transaction transaction = null;
		ProductsDetails productsDetails = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			productsDetails = (ProductsDetails) session.createQuery("from ProductsDetails where productsDetailsId = :proId")
					.setParameter("proId", productDetailsId).uniqueResult();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return productsDetails;
	}
	
	@Override
	public boolean save(ProductsDetails productsDetails) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			session.save(productsDetails);
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
	public boolean merge(ProductsDetails productsDetails) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			session.merge(productsDetails);
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

}
