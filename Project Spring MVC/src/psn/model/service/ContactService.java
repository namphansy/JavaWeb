package psn.model.service;

import psn.model.entity.Contact;

public interface ContactService {
	public Contact showContact();
	public boolean updateContact(Contact contact);
}
