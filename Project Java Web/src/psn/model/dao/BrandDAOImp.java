package psn.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import psn.model.entity.Brand;

@Repository
public class BrandDAOImp implements BrandDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Brand> getAll() {
		Session session = null;
		Transaction transaction = null;
		List<Brand> listAllBrand = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Brand.class);
			listAllBrand = criteria.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		
		return listAllBrand;
	}

	@Override
	public boolean save(Brand brand) {
		
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			session.save(brand);
			check = true;
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
		return check;
	}

	@Override
	public boolean marge(Brand brand) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			session.update(brand);
			check = true;
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		return check;
	}

	@Override
	public boolean remove(int brandId) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Brand removebrand = findById(brandId);
			session.remove(removebrand);
			check = true;
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null) session.close();
		}
		return check;
	}

	@Override
	public Brand findById(int brandId) {
		Session session = null;
		Transaction transaction = null;
		Brand brand = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			brand = (Brand) session.createQuery("from Brand where brandId = :braId")
					.setParameter("braId", brandId).uniqueResult();
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null) session.close();
		}
		
		return brand;
	} 
}
