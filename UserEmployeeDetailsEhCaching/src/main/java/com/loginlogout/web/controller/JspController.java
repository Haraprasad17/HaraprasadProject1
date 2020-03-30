package com.loginlogout.web.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;
import java.util.regex.Pattern;

import org.apache.el.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.loginlogout.web.entity.Employee;
import com.loginlogout.web.repository.EmployeeRepository;
import com.loginlogout.web.service.UserDLoginService;

@Controller
public class JspController {
	@Autowired
	UserDLoginService service;
	@Autowired
	EmployeeRepository emprepository;
	
	@RequestMapping("/loginpage")
	public String LoginPage() {
		
		return"login";
	}
	@RequestMapping("/registerpage")
	public String RegisterPage()
	{
		return"register";
	}
	@RequestMapping("/addE")
	public String goEmployee() {
		return "addemp";
	}
	@RequestMapping("/showemp")
	public String showEployee() {
		
		return"showemp";	}
	
	
	@RequestMapping("/uploadimage/{id}")
	public String UploadImage(@PathVariable("id") int id) {
		
		return "image";
	}
	
	//Destination  folder to upload the file
	private static String UPLOAD_FOLDER="C://test//";
	@PostMapping("/upload")
	public ModelAndView fileUpload(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes,Employee emp){
		
		if(file.isEmpty()) {
	 		
			return new ModelAndView("status","message","please select file and try again!!!!");
		}
		try {
			 //read and write file from the selected location
			byte[] bytes = file.getBytes();
            UUID uuid = UUID.randomUUID();
            //System.out.println("file.get===="+file.getOriginalFilename());
            String str =file.getOriginalFilename();
            String[] newf = str.split("[.]") ;
          System.out.println(Arrays.toString(newf));
          System.out.println(newf[0]);
         
            String newFileName = newf[0]+uuid+".jpg";
            
           // emprepository.save()
			     
			//Path path = Paths.get(UPLOAD_FOLDER+file.getOriginalFilename());
            Path path = Paths.get(UPLOAD_FOLDER+newFileName);
			Files.write(path,bytes);
			System.err.println("path"+path);
			//emp.setImgpath(path);
			// emprepository.save(path);
			 
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView("status","message","FileUpload Successful");
	}
	

}

