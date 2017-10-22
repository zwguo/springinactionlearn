package org.spring11.hibernate.web.controller;

import org.spring11.hibernate.dal.SpitterRepository;
import org.spring11.hibernate.dal.entity.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@Autowired
	private SpitterRepository spitterRepository;

	@RequestMapping(value = "/hello/{inputname}", method = RequestMethod.GET)
	public String hello(@PathVariable String inputname, Model model) {
		model.addAttribute("inputname", inputname);
		return "hello";
	}

	@RequestMapping(value = "/save/{username}/{password}/{firstName}/{lastName}", method = RequestMethod.GET)
	@ResponseBody
	public String saveSpitter(@PathVariable String username, @PathVariable String password,
			@PathVariable String firstName, @PathVariable String lastName) {
		Spitter spitter = new Spitter();
		spitter.setUsername(username);
		spitter.setPassword(password);
		spitter.setFirstName(firstName);
		spitter.setLastName(lastName);
		spitterRepository.save(spitter);
		spitter = spitterRepository.findByUsername(username);
		return spitter.toString();
	}
}
