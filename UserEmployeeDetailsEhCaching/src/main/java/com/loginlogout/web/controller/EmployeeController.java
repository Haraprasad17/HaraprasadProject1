package com.loginlogout.web.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//import com.csm.web.entity.FieldmasterEntity;
import com.loginlogout.web.entity.Employee;
import com.loginlogout.web.repository.EmployeeRepository;
import com.loginlogout.web.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeRepository Erepository;
	@Autowired
	EmployeeService eservice;

	@RequestMapping("/emp")
	public ModelAndView EmployeeSave(Employee employee) {
		ModelAndView mv = new ModelAndView("redirect:/showem");
		Erepository.save(employee);
		return mv;

	}
	
	//here i use ehcache technique
	@RequestMapping("/showem")
	public ModelAndView showEmployee(@RequestParam(name = "isCacheable") boolean isCacheable ) throws InterruptedException {
		ModelAndView mv = new ModelAndView("showemp");
		//mv.addObject("lists", Erepository.findAll());
		mv.addObject("lists", eservice.fetchEmployee(isCacheable));
		
		System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>controller");
		
		//List<Object> o =eservice.fetchEmployeeOrder(false);
		//o.
		
				//mv.addObject(eservice.fetchEmployeeOrder(false));
		
		//Model model = null;
		//model.addAttribute("details", eservice.fetchEmployeeOrder(isCacheable));
		return mv;

	}
	
	@ResponseBody
	
	@GetMapping("/test")
	public ResponseEntity<List<Object>> getdata(@RequestParam(name = "isCacheable") boolean isCacheable ) throws InterruptedException {
		return new ResponseEntity<List<Object>>((List<Object>) eservice.fetchEmployeeOrder(isCacheable),HttpStatus.OK);
	}
	
	

	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("redirect:/showem");
		Erepository.deleteById(id);
		return mv;
	}

	@RequestMapping("/edit{id}")
	public ModelAndView Edit(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("edit");
		mv.addObject("lists", Erepository.findById(id).orElse(new Employee()));
		return mv;
	}

	/*
	 * @RequestMapping("/update") public ModelAndView Update(@RequestParam int
	 * id,@RequestParam String firstname,@RequestParam String lastname,@RequestParam
	 * String email,@RequestParam String gender) { ModelAndView mv = new
	 * ModelAndView("redirect:/showem"); Employee emp; if(id!=0) { emp=
	 * Erepository.findById(id).orElse(new Employee()); } else { emp = new
	 * Employee(); } emp.setFirstname(firstname);
	 * System.err.println("first"+firstname); emp.setLastname(lastname);
	 * emp.setEmail(email); emp.setGender(gender); Erepository.save(emp); return mv;
	 * }
	 */
	@RequestMapping("/update")
	public ModelAndView Update(Employee emplo,@RequestParam int id) {
		ModelAndView mv = new ModelAndView("redirect:/showem");
		Employee emp = new Employee();
		if (id != 0) {
			emp = Erepository.findById(id).orElse(new Employee());
		} 
		emp.setFirstname(emplo.getFirstname());
		System.err.println("first" + emplo.getFirstname());
		emp.setLastname(emplo.getLastname());
		emp.setEmail(emplo.getEmail());
		emp.setGender(emplo.getGender());
		Erepository.save(emp);
		return mv;
	}

}
