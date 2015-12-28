package be.rd.tiles.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import be.rd.beans.Contact;
import be.rd.service.IContactService;

@Controller
@RequestMapping(value = "/contact")
public class ContactTilesCtrl {

	private static final String VIEW_CONTACT_LIST = "contact/contactlist";
	private static final String VIEW_CONTACT_DETAIL = "contact/contactdetail";
	private static final String VIEW_CONTACT_EDIT = "contact/contactedit";

	@Autowired
	private IContactService contactService;
	
	@Autowired
	private MessageSource i18nMessageSource;

	@RequestMapping(value = "listdata", method = RequestMethod.GET)
	public String list(Model uiModel) {

		List<Contact> contacts = contactService.findAll();
		uiModel.addAttribute("contacts", contacts);

		return VIEW_CONTACT_LIST;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") Long id, Model uiModel) {

		Contact contact = contactService.findById(id);
		uiModel.addAttribute("contact", contact);

		return VIEW_CONTACT_DETAIL;
	}
	
	@RequestMapping(value = "/{id}",params = "form", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, Model uiModel) {

		Contact contact = contactService.findById(id);
		uiModel.addAttribute("contact", contact);

		return VIEW_CONTACT_EDIT;
	}
	
	@RequestMapping(value = "/{id}",params = "form", method = RequestMethod.POST)
	public String update(@Valid Contact contact, BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, Locale locale) {

		if (bindingResult.hasErrors()) {
			uiModel.addAttribute(
					"message",
					new Message("error", i18nMessageSource.getMessage(
							"contact_save_fail", new Object[] {}, locale)));
			uiModel.addAttribute("contact", contact);
			return VIEW_CONTACT_EDIT;
		}
		
		uiModel.asMap().clear();
		redirectAttributes.addFlashAttribute(
				"message",
				new Message("success", i18nMessageSource.getMessage(
						"contact_save_success", new Object[] {}, locale)));
		contactService.save(contact);
		//TODO why using redirect with flashattribute why not just
		// set errormsg in model and return correct view string..??
//		return VIEW_CONTACT_DETAIL;
		return "redirect:/tiles/contact/"
				+ UrlUtil.encodeUrlPathSegment(contact.getId().toString(),
						httpServletRequest);
	}
	
	
	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String create(Model uiModel) {

		uiModel.addAttribute("contact", new Contact());
		return VIEW_CONTACT_EDIT;
	}
	
	@RequestMapping(params = "form", method = RequestMethod.POST)
	public String create(@Valid Contact contact, BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, Locale locale) {

		if (bindingResult.hasErrors()) {
			uiModel.addAttribute(
					"message",
					new Message("error", i18nMessageSource.getMessage(
							"contact_save_fail", new Object[] {}, locale)));
			uiModel.addAttribute("contact", contact);
			return VIEW_CONTACT_EDIT;
		}
		
		uiModel.asMap().clear();
		redirectAttributes.addFlashAttribute(
				"message",
				new Message("success", i18nMessageSource.getMessage(
						"contact_save_success", new Object[] {}, locale)));
		contactService.save(contact);
		//TODO why using redirect with flashattribute why not just
		// set errormsg in model and return correct view string..??
//		return VIEW_CONTACT_DETAIL;
		return "redirect:/tiles/contact/"
				+ UrlUtil.encodeUrlPathSegment(contact.getId().toString(),
						httpServletRequest);
	}
	
	static class UrlUtil {
		
		public static String encodeUrlPathSegment(String pathSegment,
				HttpServletRequest httpServletRequest) {
			String enc = httpServletRequest.getCharacterEncoding();
			if (enc == null) {
				enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
			}
			try {
				pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
			} catch (UnsupportedEncodingException uee) {
			}

			return pathSegment;
		}
	}
}
