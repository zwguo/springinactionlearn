package org.spring16.rest.web.controller;

import java.util.Arrays;
import java.util.List;

import org.spring16.rest.model.Spitter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SpitterController {

	@RequestMapping("/getname/{id}")
	@ResponseBody
	public String getName(@PathVariable("id") String id) {
		return "name-" + id;
	}

	@RequestMapping("/spittles")
	// @ResponseBody
	public List<Spitter> spittles2() {
		return getSpittles();
	}

	@RequestMapping("/spittles3")
	@ResponseBody
	public List<Spitter> spittles3() {
		return getSpittles();
	}

	@RequestMapping(value = "/spittles4", produces = "application/json")
	@ResponseBody
	public List<Spitter> spittles4() {
		return getSpittles();
	}

	@RequestMapping(value = "/spittlesxml", produces="text/plain")
	@ResponseBody
	public String spittlesxml() {
		return "TEXT";
	}
	
	@RequestMapping(value="/savespitter", consumes="application/json")
	@ResponseBody
	public String saveSpitter(@RequestBody Spitter spitter) {
		System.out.println("request to save:" + spitter.getName());
		return "OK";
	}
	
	@RequestMapping(value="/savespitter/{reason}", consumes="application/json")
	@ResponseBody
	public String saveSpitter(@RequestBody Spitter spitter, @PathVariable("reason") String reason) {
		System.out.println("request to save:" + reason + ",spitter:" + spitter.getName());
		return "OK" + reason;
	}
	
	/**
	 * http://localhost:8080/spring16-rest/testdefaultmethod?id=1&name=name1
	 * http://localhost:8080/spring16-rest/testdefaultmethod?id=1&name=name1&reason=reason1
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping("/testdefaultmethod")
	@ResponseBody
	public String testdefaultMethod(int id, String name) {
		return id + "-" + name;
	}
	
	@RequestMapping("/testform")
	@ResponseBody
	public String testform(@RequestParam int id, @RequestParam String name, @RequestParam String reason) {
		return id + "-" + name + "-" + reason;
	}
	
	@RequestMapping("/testformdata")
	@ResponseBody
	public String testformData(Spitter spitter) {
		return "testformdata:" + spitter.getId() + "-" + spitter.getName() + "-" + spitter.getRepalys();
	}

	@RequestMapping("/customeresponse")
	public ResponseEntity<String> customeResponse(int id) {
		String message = "found";
		HttpStatus status = HttpStatus.OK;
		if(id > 100) {
			message = null;
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(message, status);
	}
	
	@RequestMapping("/notaccept")
	@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE)
	public void notfound() {
	}
	
	@RequestMapping("/movestatus")
	@ResponseStatus(value=HttpStatus.MOVED_PERMANENTLY)
	@ResponseBody
	public String notfoundwithmessage() {
		return "notok";
	}
	
	/**
	 * 产生数据
	 * 
	 * @return
	 */
	private static final List<Spitter> getSpittles() {
		Spitter spitter = new Spitter();
		spitter.setId(1);
		spitter.setName("abc");
		spitter.setMessages(Arrays.asList("1", "b", "cdw"));
		spitter.setRepalys(new String[] { "repaly1", "repaly2" });

		Spitter spitter2 = new Spitter();
		spitter2.setId(2);
		spitter2.setName("张三");
		spitter2.setMessages(Arrays.asList("2", "b", "cdw"));
		spitter2.setRepalys(new String[] { "repaly3", "repaly4" });
		return Arrays.asList(spitter, spitter2);
	}
}
