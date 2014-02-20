package be.rd.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import be.rd.beans.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

	// implentatoin is not required spring-data creates condition
	// depending of argumentname or methodname and the name of bean property 
	// which is associated with a columnname
	public List<Contact> findByFirstName(String firstName);
}
