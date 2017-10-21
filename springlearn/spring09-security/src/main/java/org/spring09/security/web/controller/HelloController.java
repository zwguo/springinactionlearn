package org.spring09.security.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(method=RequestMethod.GET, value= {"/", "/hello/{name}"})
	public String hello(@PathVariable String name) {
		request.setAttribute("name", name);
		return "hello";
	}
	
	@RequestMapping(method=RequestMethod.GET, value= {"/security"})
	public String security() {
		request.setAttribute("name", "security");
		return "hello";
	}
	
	@RequestMapping(method=RequestMethod.GET, value= {"/me/{name}"})
	public String me(@PathVariable String name) {
		request.setAttribute("name", name);
		return "me";
	}
}
