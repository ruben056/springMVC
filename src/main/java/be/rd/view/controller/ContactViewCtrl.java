package be.rd.view.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.rd.beans.Contact;
import be.rd.service.IContactService;

@Controller
@RequestMapping(value = "/contact")
public class ContactViewCtrl {
	
	private static final String VIEW_CONTACT_LIST = "contact/contactlist";
	
	@Autowired
	private IContactService contactService;
	
	
	@RequestMapping(value= "listdata", method = RequestMethod.GET)
	public String list(Model uiModel){
		
		List<Contact> contacts = contactService.findAll();
		uiModel.addAttribute("contacts", contacts);
		
		return VIEW_CONTACT_LIST;
	}
	
	
}
