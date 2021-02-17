package psn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import psn.model.entity.Contact;
import psn.model.service.ContactService;

@Controller
@RequestMapping(value = "/contactController")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value = "/adminShowContact.htm")
	private ModelAndView showContact() {
		ModelAndView mav = new ModelAndView("showContact");
		Contact contact = contactService.showContact();
		mav.addObject("contact", contact);
		return mav;
	}
	
	@RequestMapping(value = "/updateContact.htm", method = RequestMethod.POST)
	private String updateContact(Contact contact) {
		boolean check = contactService.updateContact(contact);
		if(check) {
			return "adminShowContact.htm";
		}
		return "error";
	}
}
