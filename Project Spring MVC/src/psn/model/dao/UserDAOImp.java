package psn.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import psn.model.entity.WebUser;

@Repository
public class UserDAOImp implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public WebUser getUserByUserName(String userName) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		WebUser webUser = (WebUser) session.createQuery("from WebUser where username = :username")
				.setParameter("username", userName).uniqueResult();
		
		return webUser;
	}

	@Override
	public List<WebUser> getAllWebUser() {
		Session session = null;
		Transaction transaction = null;
		List<WebUser> listWebUser = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			String query = "Select wu FROM WebUser wu "
					+ "right Join UserGroup ug on wu.userId = ug.webUser.userId "
					+ "Where ug.webGroup.groupId = :id";
			
			listWebUser = session.createQuery(query, WebUser.class).setParameter("id", 2).list();
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		
		return listWebUser;
	}

	@Override
	public boolean save(WebUser webUser) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			// Lưu mật khẩu bằng Bcrypt
			String pass = webUser.getPass();
			String hash = BCrypt.hashpw(pass, BCrypt.gensalt(10));
			webUser.setPass(hash);
			
			session.save(webUser);
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
	public boolean merge(WebUser webUser) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			// Lưu mật khẩu bằng Bcrypt
			String pass = webUser.getPass();
			String hash = BCrypt.hashpw(pass, BCrypt.gensalt(10));
			webUser.setPass(hash);
			
			session.merge(webUser);
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
	public List<WebUser> getAllWebAdmin() {
		Session session = null;
		Transaction transaction = null;
		List<WebUser> listWebAdmin = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			String query = "Select wu FROM WebUser wu "
					+ "right Join UserGroup ug on wu.userId = ug.webUser.userId "
					+ "Where ug.webGroup.groupId = :id";
			
			listWebAdmin = session.createQuery(query, WebUser.class).setParameter("id", 1).list();
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		
		return listWebAdmin;
	}
	
	public Integer totalAccountUser() {
		Session session = null;
		Transaction transaction = null;
		int total = 0;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			long t;
			
			t =  (long) session.createQuery("Select COUNT(userGroupId) FROM UserGroup ug WHERE ug.webGroup.groupId = :id")
				.setParameter("id", 2).uniqueResult();
			
			total = Long.valueOf(t).intValue();
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		
		return total;
	}

	@Override
	public boolean checkUserNameRegister(String userName) {
		boolean check = false;
		
		WebUser user = getUserByUserName(userName);
		if(user == null) {
			return !check;
		}
		return check;
	}
}
