package psn.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psn.model.dao.ContactDAO;
import psn.model.entity.Contact;

@Service
public class ContactServiceImp implements ContactService{
	
	@Autowired
	private ContactDAO contactDao;
	
	@Override
	public Contact showContact() {
		// TODO Auto-generated method stub
		return contactDao.showContact();
	}

	@Override
	public boolean updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return contactDao.updateContact(contact);
	}

}
