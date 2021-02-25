package psn.model.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import psn.model.entity.Products;

@Repository
public class ProductDAOImp implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Products> getAll() {
		Session session = null;
		Transaction transaction = null;

		List<Products> listAllProduct = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			listAllProduct = session.createQuery("from Products").list();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return listAllProduct;
	}

	@Override
	public boolean save(Products pro) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			// Lưu ngày tạo sản phẩm
			long millis = System.currentTimeMillis();
			Date date = new Date(millis);
			pro.setCreated(date);

			session.save(pro);
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
	public boolean merge(Products pro) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			// Lưu ngày tạo sản phẩm
			long millis = System.currentTimeMillis();
			Date date = new Date(millis);
			pro.setCreated(date);

			session.merge(pro);
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
	public boolean remove(String productId) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Products products = findById(productId);
			session.remove(products);

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
	public Products findById(String productId) {
		Session session = null;
		Transaction transaction = null;
		Products products = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			products = (Products) session.createQuery("from Products where productId = :proId")
					.setParameter("proId", productId).uniqueResult();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return products;
	}
	
	
	//----- Cập nhật trạng thái cho sản phẩm ------------//
	@Override
	public boolean updateStatus(Products products) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			boolean status = products.isProductStatus();
			products.setProductStatus(!status);

			session.merge(products);
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
	
	//------- Lấy danh sách sản phẩm theo trạng thái -----------//
	@Override
	public List<Products> getListProductByStatus(Boolean status) {
		Session session = null;
		Transaction transaction = null;
		List<Products> listProductByStatus = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Products.class);
			criteria.add(Restrictions.eq("productStatus", status));
			listProductByStatus = criteria.list();
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return listProductByStatus;
	}
	
	//------- Số sản phẩm đang Active ------------------//
	public Integer totalProdcutActive(Boolean status) {
		Session session = null;
		Transaction transaction = null;
		int total = 0;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			long t;

			t = (long) session.createQuery("Select COUNT(productId) FROM Products WHERE productStatus = :status")
					.setParameter("status", status).uniqueResult();

			total = Long.valueOf(t).intValue();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return total;
	}
	
	
	//----- Kiểm tra mã sản phẩm khi tạo mới ---------//
	@Override
	public boolean checkProductId(String productId) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			@SuppressWarnings("unchecked")
			List<Products>listAllProduct = session.createQuery("from Products").list();
			
			for(Products pro : listAllProduct) {
				if(pro.getProductId().equals(productId)) {
					check = true;
					break;
				}
			}
			
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
