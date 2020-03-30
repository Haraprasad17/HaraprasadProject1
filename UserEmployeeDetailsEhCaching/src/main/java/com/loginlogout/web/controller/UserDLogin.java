package com.loginlogout.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.loginlogout.web.entity.UserD;
import com.loginlogout.web.repository.UserDRepository;
import com.loginlogout.web.service.UserDLoginService;

@Controller
public class UserDLogin {
	@Autowired
	UserDRepository Repository;
	@Autowired
	UserDLoginService loginservice;
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	//registration and save schema
	@RequestMapping("/register")
	public ModelAndView Register(UserD user) {
		ModelAndView mv = new ModelAndView("login");
		Repository.save(user);
		return mv;
	}
	 @RequestMapping("/login")
	public String WelcomePage(ModelMap model,@RequestParam String name,String password)
	{
		boolean isValidateuser=loginservice.ValidateUserD(name, password);
		if(!isValidateuser) {
			
			model.put("errorMessage", "InvalidCredentials");
    		return "login";	

		}
		return "success";
	}
	

}
