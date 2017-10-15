package org.spring06.webmvc.senior.webmvc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(method=RequestMethod.GET, value="/")
public class HelloController {
	
	@RequestMapping
	public String getHelloJsp() {
		return "hello";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/upload")
	public String upload(@RequestPart byte[] img) throws IOException {
		String path = "/Users/guozhanwang/java/gitsource/springinactionlearn/springlearn/spring06-webmvc-senior/src/main/webapp/WEB-INF/upload";
		path = path + "/" + System.currentTimeMillis();
		FileOutputStream stream = new FileOutputStream(path);
		stream.write(img);
		stream.flush();
		stream.close();
		return "redirect:/showImage";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/upload2")
	public String upload(@RequestPart MultipartFile img) throws IOException {
		String path = "/Users/guozhanwang/java/gitsource/springinactionlearn/springlearn/spring06-webmvc-senior/src/main/webapp/WEB-INF/upload";
		path = path + "/" + System.currentTimeMillis();
		img.transferTo(new File(path + "-" + img.getOriginalFilename()));
		return "redirect:/showImage";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/showImage")
	public String showImage() {
		return "showImage";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/validatenum/{id}")
	public String ValidateNum(@PathVariable int id) {
		if(id % 2 == 0) {
			return "hello";
		}
		else {
			throw new NotEvenNumberException();
		}
	}
	
	//@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="not a even number")
	public class NotEvenNumberException extends RuntimeException{
		
	}
	
	@ExceptionHandler(NotEvenNumberException.class)
	public String handleNotEvenNumber() {
		return "hello";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/generatemodel")
	public String generateModel(RedirectAttributes model) {
		SomeModel sm = new SomeModel();
		sm.setId(1);
		sm.setName("n" + System.currentTimeMillis());
		model.addAttribute("name", sm.getName());
		model.addAttribute("id", sm.getId());
		model.addFlashAttribute("sm", sm);
		return "redirect:/redirectmodel/{name}";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/redirectmodel/{name}")
	public String generateModel(@PathVariable String name, Model model) {
		if(!model.containsAttribute("sm")) {
			//create anthoer
			SomeModel sm = new SomeModel();
			sm.setId(2);
			sm.setName("n" + System.currentTimeMillis());
			model.addAttribute("sm", sm);
		}
		return "showmodels";
	}
	
	public class SomeModel{
		private int id;
		private String name;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
}
