package org.spring21.springboot.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.spring21.springboot.dal.ContactRepository;
import org.spring21.springboot.web.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
@RequestMapping("/")
public class ContactController {
	private ContactRepository contactRepo;
	
	@Autowired
	public ContactController(ContactRepository contactRepo) {
		this.contactRepo = contactRepo;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Map<String, Object> model) {
		List<Contact> contacts = contactRepo.findAll();
		model.put("contacts", contacts);
		return "home";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(Contact contact) {
		contactRepo.save(contact);
		return "redirect:/";
	}
}
