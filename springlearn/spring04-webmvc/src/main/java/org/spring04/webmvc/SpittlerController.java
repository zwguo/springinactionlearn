package org.spring04.webmvc;

import javax.validation.Valid;

import org.spring04.webmvc.data.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("spitter")
public class SpittlerController {
	private SpitterRepository spitterRepository;
	
	@Autowired
	public SpittlerController(SpitterRepository spitterRepository) {
		this.spitterRepository = spitterRepository;
	}
	/**
	 * 返回注册表单页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm() {
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String processRegistratioin(@Valid Spitter spitter, BindingResult errors) {
		if(errors.hasErrors()) {
			return "registerForm";
		}
		spitterRepository.save(spitter);
		return "redirect:/spitter/" + spitter.getUsername();
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String showSpitterProfile(@PathVariable("username") String username, Model model) {
		Spitter spitter = spitterRepository.findByUsername(username);
		model.addAttribute(spitter);
		return "profile";
	}
}
