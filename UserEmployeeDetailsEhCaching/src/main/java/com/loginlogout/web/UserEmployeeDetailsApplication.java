package com.loginlogout.web;

import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserEmployeeDetailsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(UserEmployeeDetailsApplication.class, args);
		
		
		//System.setProperty("name.me", "haraprasad");
		//Properties p = new Properties();
		// Properties prop = readPropertiesFile("credentials.properties");
		//p.put("name.me", "haraprasad moharana");
		//System.setProperties(p);
		System.out.println(System.getProperty("name.me"));
		
		
		
		
	}

}
