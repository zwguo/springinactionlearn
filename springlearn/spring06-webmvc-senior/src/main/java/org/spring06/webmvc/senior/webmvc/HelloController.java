package org.spring06.webmvc.senior.webmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(method=RequestMethod.GET, value="/")
public class HelloController {
	
	@RequestMapping
	public String getHelloJsp() {
		return "Hello";
	}
	
}
