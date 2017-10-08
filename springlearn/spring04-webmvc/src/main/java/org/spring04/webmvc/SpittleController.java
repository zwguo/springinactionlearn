package org.spring04.webmvc;

import java.util.List;

import org.spring04.webmvc.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	private static final String MAX_LONG_AS_STRING = "9223372036854775807";
	
	private SpittleRepository spittleRepository;
	
	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}

	/**
	 * 和spittles(long, int)方法不能共存，否则spring不知道该把请求分配给谁
	 * @param max
	 * @param count
	 * @return
	 */
//	@RequestMapping(method=RequestMethod.GET)
//	public String spittles(Model model) {
//		model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
//		return "spittles";
//	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Spittle> spittles(@RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max, 
			@RequestParam(value="count", defaultValue="20") int count){
		return spittleRepository.findSpittles(max, count);
	}
	
	@RequestMapping(value="/show", method=RequestMethod.GET)
	public String showSpittle(@RequestParam("spittle_id") long spittleId, Model model) {
		model.addAttribute(spittleRepository.findOne(spittleId));
		return "spittle";
	}
	
	@RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
	public String spittle(@PathVariable("spittleId") long spittleId, Model model) {
		model.addAttribute(spittleRepository.findOne(spittleId));
		return "spittle";
	}
}
