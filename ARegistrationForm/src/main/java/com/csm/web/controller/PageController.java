package com.csm.web.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.csm.web.entity.FieldmasterEntity;
import com.csm.web.entity.FinalEntity;
import com.csm.web.repository.FieldmasterRepository;
import com.csm.web.repository.FinalRepository;
import com.csm.web.repository.LanguagemasterRepository;
import com.csm.web.repository.WebpagemasterRepository;

@Controller
public class PageController {

	@Autowired
	WebpagemasterRepository webrepo;
	@Autowired
	LanguagemasterRepository langrepo;
	@Autowired
	FieldmasterRepository fieldrepo;
	@Autowired
	FinalRepository finalrepo;

	@RequestMapping("/registration")
	public ModelAndView registraion() {
		ModelAndView mv = new ModelAndView("registration");
		/*
		 * mv.addObject("allrequireddata", finalrepo.AllRequiredInformation());
		 * mv.addObject("English", finalrepo.English()); mv.addObject("FRENCH",
		 * finalrepo.FRENCH()); mv.addObject("Kinyarwanda", finalrepo.Kinyarwanda());
		 * mv.addObject("Swahili", finalrepo.Swahili());
		 */
		/* mv.addObject("finaltabledata",finalrepo.findAll()); */
		
		
		  java.util.List<Object[]> French =finalrepo.FRENCH();
		 French.forEach(french->mv.addObject("frenchdata",french[3]) );
		 
				
		
		
		//mv.addObject("frenchcolumn",rench[3]);
		return mv;
	}
	
	//open edit 
		@RequestMapping("/editFieldmaster/{fieldID}")
		public  ModelAndView Edit(@PathVariable("fieldID") int fieldID) {
			ModelAndView mv =new ModelAndView("editFieldmaster");
			mv.addObject("FieldmasterEntity", fieldrepo.findById(fieldID).orElse(new FieldmasterEntity()));
		/*
		 * mv.addObject("languagemasterData", langrepo.findAll());
		 * mv.addObject("webpagemasterData", webrepo.findAll());
		 * mv.addObject("finaltabledata",finalrepo.findAll());
		 */
			return mv;
		}
		
		//now update 
		@PostMapping("updatefieldmaster/{fieldID}")
		public String updateUser(@PathVariable("fieldID") int fieldID, @Valid FieldmasterEntity fieldmasterEntity, 
		  BindingResult result, Model model) {
		    if (result.hasErrors()) {
		    	fieldmasterEntity.setFieldID(fieldID);
		    	
		        return "editFieldmaster";
		    }
		    FieldmasterEntity f = fieldrepo.findById(fieldID).orElse(new FieldmasterEntity() );
		    fieldmasterEntity.setUpdatedOn(new Date());
		    fieldmasterEntity.setCreatedBy(1);
		    fieldmasterEntity.setUpdatedBy(1);
		    fieldmasterEntity.setCreatedOn(f.getCreatedOn());
		    
		    
		    fieldrepo.save(fieldmasterEntity);
		/*
		 * model.addAttribute("fieldmasterEntitys", userRepository.findAll()); return
		 * "index";
		 */
		    return"redirect:/viewpage";
		}
		
		//open update page
		@GetMapping("finalEntity/{slno}")
		public  ModelAndView Editf(@PathVariable("slno") int slno) {
			ModelAndView mv =new ModelAndView("editFinalmaster");
			mv.addObject("FinalEntity", finalrepo.findById(slno).orElse(new FinalEntity()));
		/*
		 * mv.addObject("languagemasterData", langrepo.findAll());
		 * mv.addObject("webpagemasterData", webrepo.findAll());
		 * mv.addObject("finaltabledata",finalrepo.findAll());
		 */
			return mv;
		}
		
		
		//update kennyarewanda data
		@GetMapping("updatekynyarwanda/{slno}")
		public String updateKennyaRewandaData(@PathVariable("slno") int slno, @Valid FinalEntity finalentity,BindingResult result ) throws Exception {
			if(result.hasErrors()) {
				finalentity.setSlno(slno);
				
			 throw new Exception("can't update");
			}
			FinalEntity f = finalrepo.findById(slno).orElse(new FinalEntity());
			finalentity.setIntFieldId(f.getIntFieldId());
			finalentity.setLanguageID(f.getLanguageID());
		/* finalentity.setSlno(f.getSlno()); */
			finalentity.setWebpageID(f.getWebpageID());
			finalrepo.save(finalentity);
			 return"redirect:/Kinyarwanda";
		}
	
	
	

}
