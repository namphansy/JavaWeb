package psn.model.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import psn.model.entity.Contact;

@Repository
public class ContactDAOImp implements ContactDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Contact showContact() {
		Session session = null;
		Transaction transaction = null;
		Contact contact = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Contact.class);
			contact = (Contact) criteria.uniqueResult();
			
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
		return contact;
	}

	@Override
	public boolean updateContact(Contact contact) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			session.merge(contact);
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

}
