package be.rd.restfull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import be.rd.beans.Contact;
import be.rd.beans.Contacts;

@ContextConfiguration()
@RunWith(SpringJUnit4ClassRunner.class)
public class TestService {

	private static final String HOST_URL = "http://localhost:8080";
	private static final String REST_DISPATCHER_SERVLET_PREFIX = "/rest";	
	private static final String URL_GET_ALL_CONTACTS = HOST_URL + REST_DISPATCHER_SERVLET_PREFIX + "/contact/listdata";
	private static final String URL_GET_CONTACT_BY_ID = HOST_URL + REST_DISPATCHER_SERVLET_PREFIX + "/contact/{id}";
	private static final String URL_CREATE_CONTACT = HOST_URL + REST_DISPATCHER_SERVLET_PREFIX + "/contact/";
	private static final String URL_UPDATE_CONTACT = HOST_URL + REST_DISPATCHER_SERVLET_PREFIX + "/contact/{id}";
	private static final String URL_DELETE_CONTACT = HOST_URL + REST_DISPATCHER_SERVLET_PREFIX + "/contact/{id}";
	
	@Autowired
	private RestTemplate template;
	
	@Test
	public void testRestfullWS(){		
		// retrieve
		Contacts allContacts = template.getForObject(URL_GET_ALL_CONTACTS, Contacts.class);
		listContacts(allContacts);
	
		Contact contact = template.getForObject(URL_GET_CONTACT_BY_ID, Contact.class, 1);
		Assert.assertEquals("Clarence", contact.getFirstName());
		
		contact = template.getForObject(URL_GET_CONTACT_BY_ID, Contact.class, 2);
		Assert.assertEquals("Scott", contact.getFirstName());
		
		// update
		contact.setFirstName("Ruben");
		template.put(URL_UPDATE_CONTACT, contact, 2);
		Assert.assertEquals(contact.getFirstName(), "Ruben");
		
		// delete
		template.delete(URL_DELETE_CONTACT, 1);
		contact = template.getForObject(URL_GET_CONTACT_BY_ID, Contact.class, 1);
		Assert.assertNull(contact);

		// create (change james to anything smaller then 3 characters and you will get bad request thx to jsr 303 validation)
		Contact contactNew = new Contact();
		contactNew.setFirstName("James");
		contactNew.setLastName("Gosling");
		contactNew = template.postForObject(
		URL_CREATE_CONTACT, contactNew, Contact.class);
		
		System.out.println("Contact created successfully: " + contactNew);
	}

	private static void listContacts(Contacts contacts) {
		for (Contact contact : contacts.getContacts()) {
			System.out.println(contact);
		}
		System.out.println("");
	}

}
