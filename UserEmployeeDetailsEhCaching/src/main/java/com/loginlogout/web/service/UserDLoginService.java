package com.loginlogout.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginlogout.web.repository.UserDRepository;

@Service
public class UserDLoginService {
	@Autowired
	UserDRepository DRepository;
	
	public boolean ValidateUserD(String username,String password) {
		
		if(DRepository.findByUsernameAndPassword( username,password)!=null) {
			return true;
		}
		return false;
	}

	
	
}
