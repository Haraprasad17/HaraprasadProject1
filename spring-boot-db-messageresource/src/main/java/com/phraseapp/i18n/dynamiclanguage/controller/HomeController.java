package com.phraseapp.i18n.dynamiclanguage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phraseapp.i18n.dynamiclanguage.repository.LanguageRepository;

@Controller
public class HomeController {
	@Autowired
	LanguageRepository lrepo;

	@RequestMapping("/")
	public String welcome() {
		return "index";
	}
	
	

	@RequestMapping("/reg")
	public String reg() {
		return "Registration";
	}
	
	@RequestMapping("/data")
	public ModelAndView master() {
		
		ModelAndView mv = new ModelAndView("master");
		mv.addObject("dataenglish",lrepo.findByLocale("en"));
		mv.addObject("datafrench",lrepo.findByLocale("fr"));
		mv.addObject("datakin",lrepo.findByLocale("kin"));
		mv.addObject("datasw",lrepo.findByLocale("sw"));
		return mv;
	}

}
