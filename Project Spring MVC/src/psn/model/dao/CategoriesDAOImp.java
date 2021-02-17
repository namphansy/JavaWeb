package psn.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import psn.model.entity.Categories;

@Repository
public class CategoriesDAOImp implements CategoriesDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	@Override
	public List<Categories> getAll() {
		Session session = null;
		Transaction transaction = null;
		List<Categories> listAllCategories = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Categories.class);
			
			listAllCategories = criteria.list();
			transaction.commit();
		
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		return listAllCategories;
	}

	@Override
	public boolean save(Categories cat) {
	
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(cat);
			check = true;
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
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
	public boolean merge(Categories cat) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.merge(cat);
			check = true;
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null) session.close();
		}
		return check;
	}

	@Override
	public boolean remove(int catalogId) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Categories removeCategories = findById(catalogId);
			session.remove(removeCategories);
			check = true;
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null) session.close();
		}
		return check;
	}

	@Override
	public Categories findById(int catalogId) {
		Session session = null;
		Transaction transaction = null;
		Categories categories = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			categories = (Categories) session.createQuery("from Categories where catalogId = :catId")
					.setParameter("catId", catalogId).uniqueResult();
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null) session.close();
		}
		return categories;
	}

	@Override
	public List<Categories> listUpdateParent(List<Categories> listCategories, int catalogId) {
		Categories ct = new Categories(0, "không có danh mục cha");
		listCategories.add(ct);
		for(int i = 0; i < listCategories.size(); i++) {
			if(listCategories.get(i).getCatalogId() == catalogId
					|| listCategories.get(i).getParentId() == catalogId) 
			{
				listCategories.remove(i);
			}
		}
		return listCategories;
	}
}
