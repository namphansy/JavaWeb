package psn.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import psn.model.entity.Blog;

@Repository
public class BlogDAOImp implements BlogDAO{
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public List<Blog> listBlog() {
		Session session = null;
		Transaction transaction = null;
		List<Blog> listBlog = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Blog.class);
			listBlog = criteria.list();
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		return listBlog;
	}

	@Override
	public boolean save(Blog blog) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			session.save(blog);
			check = true;
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		return check;
	}

	@Override
	public boolean merge(Blog blog) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			session.merge(blog);
			check = true;
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		return check;
	}

	@Override
	public boolean remove(int blogId) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Blog removeBlog = findById(blogId);
			session.remove(removeBlog);
			
			check = true;
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		return check;
	}

	@Override
	public Blog findById(int blogId) {
		Session session = null;
		Transaction transaction = null;
		Blog blog = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			blog = (Blog) session.createQuery("from Blog where blogId = :blogId")
					.setParameter("blogId", blogId).uniqueResult();
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null) session.close();
		}
		return blog;
	}

}
