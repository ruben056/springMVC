package be.rd.service;

import java.util.List;

import be.rd.beans.Contact;

public interface IContactService {

	public List<Contact> findAll();
	public List<Contact> findByFirstName(String firstName);
	public Contact findById(Long id);
	public Contact save(Contact contact);
	public void delete(Contact contact);
}
