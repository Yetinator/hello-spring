package org.launchcode.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.launchcode.models.HelloLog;
import org.launchcode.models.HelloMessage;
import org.launchcode.models.LanguageMap;
import org.launchcode.models.dao.HelloLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	
	@Autowired
	private HelloLogDao helloLogDao;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String helloForm(Model model) {
		
		//map of languages for use by drop down menu
		LanguageMap Languages = new LanguageMap();
		ArrayList<String> Lang = Languages.getLanguages();
		
				
		model.addAttribute("Lang", Lang);
		return "helloform";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
 	public String hello(HttpServletRequest request, Model model){
		//get name from request
		String name = request.getParameter("name");
		String Language = request.getParameter("Language");
		
		if(name == null || name == "")
			name = "world";
		
		//check language default to English
		if(Language == null || Language == "")
			Language = "English";
		
		HelloLog log = new HelloLog(name);
		helloLogDao.save(log);
		
		
		model.addAttribute("message", HelloMessage.getMessage(name, Language));
		model.addAttribute("title", "Hello, Spring, Response");
		return "hello";
	}
	
	@RequestMapping(value="/log")
	public String log(Model model){
		//get data out of database
		List<HelloLog> logs = helloLogDao.findAll();
		
		//put data into template
		model.addAttribute("logs", logs);
		
		return "log";
	}

}
