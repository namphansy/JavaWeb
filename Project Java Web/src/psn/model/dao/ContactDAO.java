package psn.model.dao;

import psn.model.entity.Contact;

public interface ContactDAO {
	public Contact showContact();
	public boolean updateContact(Contact contact);
}
