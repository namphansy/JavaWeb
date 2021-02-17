package psn.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import psn.model.entity.UserGroup;
import psn.model.entity.WebGroup;
import psn.model.entity.WebUser;

@Repository
public class UserGroupDAOImp implements UserGroupDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveNewAdmin(WebUser webUser) {
		Session session = null;
		Transaction transaction = null;
		boolean check = false;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			UserGroup newUserGroup = new UserGroup();
			newUserGroup.setWebUser(webUser);
			WebGroup webGroup = new WebGroup(1, "ROLE_ADMIN", true);
			newUserGroup.setWebGroup(webGroup);
			
			session.save(newUserGroup);
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

}
