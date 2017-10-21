package org.spring09.security.web.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.spring09.security.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	
	public static Map<String, User> userMap = new ConcurrentHashMap();

	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String showUser(@PathVariable String username, Model model) {
		if(userMap.containsKey(username)) {
			model.addAttribute("user", userMap.get(username));
		}
		else {
			model.addAttribute("user", null);
		}
		return "user";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(User user, Model model) {
		userMap.put(user.getUsername(), user);
		model.addAttribute("user", user);
		return "user";
	}
	
	@RequestMapping("/logininfo")
	@ResponseBody
	public String getLoginInfo() {
		Authentication ac = SecurityContextHolder.getContext().getAuthentication();
		String userName = ac.getName();
		String principal = ac.getPrincipal().getClass().getCanonicalName();
		return userName + "-" + principal + "-" + ac.getPrincipal();
	}
}
