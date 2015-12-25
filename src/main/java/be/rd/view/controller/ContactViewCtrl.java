package be.rd.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/contact")
public class ContactViewCtrl {
	
	@RequestMapping(value ="/showMessage")
	public String showMassage(Model uiModel){
		uiModel.addAttribute("message", "Working view!!");
		return "showMessage";
	}
}
