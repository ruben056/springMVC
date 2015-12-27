package be.rd.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="msg")
public class MessageCtrl {

	private static final String VIEW_SHOW_MSG ="msg/showMessage";
	
	@RequestMapping(value = "/{msg}", method = RequestMethod.GET)
	public String showMessage(@PathVariable("msg") String msg, Model uiModel){
		uiModel.addAttribute("message", msg);
		return VIEW_SHOW_MSG;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showMessage(Model uiModel){
		uiModel.addAttribute("message", "Working view!!");
		return VIEW_SHOW_MSG;
	}
}
