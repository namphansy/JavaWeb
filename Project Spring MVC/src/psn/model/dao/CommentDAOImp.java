package psn.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import psn.model.entity.Comment;

@Repository
public class CommentDAOImp implements CommentDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Comment> listComment() {
		Session session = null;
		Transaction transaction = null;
		List<Comment> listComment = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Comment.class);
			listComment = criteria.list();
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		return listComment;
	}

	@Override
	public boolean remove(int commentId) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			 Comment comment = findById(commentId);
			 session.remove(comment);
			 
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
	public Comment findById(int commentId) {
		Session session = null;
		Transaction transaction = null;
		Comment comment = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			comment = (Comment) session.createQuery("from Comment where commentId = :commentId")
					.setParameter("commentId", commentId);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		
		return comment;
	}

	@Override
	public boolean updateStatus(Comment comment) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			boolean status = comment.isCommentStatus();
			comment.setCommentStatus(!status);
			
			session.merge(comment);
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
