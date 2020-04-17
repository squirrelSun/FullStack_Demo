package com.test;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	/**
	 * 假设：localhost:8080/SpringMVC/hello
	 */
	@RequestMapping(value = "hello" ,method = RequestMethod.POST)
	public String hello() {
		System.out.println("*****");
		return "success";//视图名称
	}
	
	@RequestMapping(value = "hello" ,method = RequestMethod.POST)
	public ModelAndView param1() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("username", "root");
		mav.setViewName("success");
		return mav;
	}
	@RequestMapping(value = "hello" ,method = RequestMethod.POST)
	public String param2(Map<String , Object> map) {
		map.put("username", "admin");
		return "success";
	}
	@RequestMapping(value = "hello" ,method = RequestMethod.POST)
	public String parm3(Model model) {
		model.addAttribute("username", "qwe");
		return "success";
	}
	
	//处理JSON
	@RequestMapping("/testJSON")
	@ResponseBody
	public String testJSON() {
		return "success";
	}
	
}
