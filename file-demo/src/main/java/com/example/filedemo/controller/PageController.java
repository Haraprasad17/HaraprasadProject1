package com.example.filedemo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
	
	
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String login(Model model, String error, String logout) {
	        if (error != null)
	            model.addAttribute("error", "Your username and password is invalid.");

	        if (logout != null)
	            return "logout";

	        return "loginPage";
	    }
	 
	 

	 @RequestMapping("/indx")
	    public String indexPage()
	    {
	    	return "indx";
	    }
	 
	 //@ResponseBody
	 @GetMapping("/get")
     public String readFiles(Model model) {
		 try (Stream<Path> walk = Files.walk(Paths.get("D:\\MYNEWPROJECT\\2\\spring-boot-file-upload-download-rest-api-example-master\\spring-boot-file-upload-download-rest-api-example-master\\src\\main\\resources\\AllFiles"))) {

				List<String> result = walk.filter(Files::isRegularFile)
						.map(x -> x.toString()).collect(Collectors.toList());

				result.forEach(System.out::println);
				 model.addAllAttributes(result);
			/*
			 * String str = result.get(0); String[] patharr = str.split("\\\\");
			 * System.out.println(patharr[9]); for (String a : patharr)
			 * System.err.println(a);
			 */
			   
				System.err.println("index =" +result.get(0).toString().split("\\\\")[9]);

			} catch (IOException e) {
				e.printStackTrace();
			}
		
		 return "allFilesPage";
     }
	 
	 
	
}
