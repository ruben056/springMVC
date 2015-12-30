package be.rd.security.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import be.rd.beans.Contact;
import be.rd.service.IContactService;
import be.rd.tiles.controller.Message;

@Controller
@RequestMapping(value = "/security")
public class SecurityCtrl {

	private static final String VIEW_CONTACT_LIST = "contact/contactlist";
	
	@Autowired
	private MessageSource i18nMessageSource;
	
	@Autowired
	private IContactService contactService;

	@RequestMapping("/loginfail")
	public String loginFail(Model uiModel, Locale locale) {
		
		uiModel.addAttribute(
				"message",
				new Message("error", i18nMessageSource.getMessage(
						"message_login_fail", new Object[] {}, locale)));
		
		List<Contact> contacts = contactService.findAll();
		uiModel.addAttribute("contacts", contacts);
		
		return VIEW_CONTACT_LIST;
	}
}
