package com.csm.web.controller;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.csm.web.entity.FieldmasterEntity;
import com.csm.web.entity.FinalEntity;
import com.csm.web.entity.LanguagemasterEntity;
import com.csm.web.entity.WebpagemasterEntity;
import com.csm.web.repository.FieldmasterRepository;
import com.csm.web.repository.FinalRepository;
import com.csm.web.repository.LanguagemasterRepository;
import com.csm.web.repository.WebpagemasterRepository;

@Controller
public class Languagepagecontroller {
	@Autowired
	WebpagemasterRepository webrepo;
	@Autowired
	LanguagemasterRepository langrepo;
	@Autowired
	FieldmasterRepository fieldrepo;
	@Autowired
	FinalRepository finalrepo;

	@RequestMapping("/")
	public String home() {

		return "home";
		
	}
	
	//each and every language data comming from finalRepository
	@RequestMapping("/data")
	public ModelAndView alldataHome() {
		
		ModelAndView mv = new ModelAndView("home");
		
		mv.addObject("allrequireddata",finalrepo.AllRequiredInformation());
		mv.addObject("English",finalrepo.English());
		mv.addObject("FRENCH",finalrepo.FRENCH());
		mv.addObject("Kinyarwanda",finalrepo.Kinyarwanda());
		mv.addObject("Swahili",finalrepo.Swahili());
		
		return mv;
	}
	
	//English
	//show English
	@RequestMapping("/English")
    public ModelAndView English() {
		
		ModelAndView mv = new ModelAndView("English");

		mv.addObject("English",finalrepo.English());
		//mv.addObject("FRENCH",finalrepo.FRENCH());
		//mv.addObject("Kinyarwanda",finalrepo.Kinyarwanda());
		//mv.addObject("Swahili",finalrepo.Swahili());
		
		return mv;
	}
	
	//French
		//show French
		@RequestMapping("/FRENCH")
	    public ModelAndView FRENCH() {
			
			ModelAndView mv = new ModelAndView("French");

			//mv.addObject("English",finalrepo.English());
			mv.addObject("FRENCH",finalrepo.FRENCH());
			//mv.addObject("Kinyarwanda",finalrepo.Kinyarwanda());
			//mv.addObject("Swahili",finalrepo.Swahili());
			
			return mv;
		}
	
		//French
				//show Kinyarwanda
				@RequestMapping("/Kinyarwanda")
			    public ModelAndView Kinyarwanda() {
					
					ModelAndView mv = new ModelAndView("Kinyarwanda");

					//mv.addObject("English",finalrepo.English());
					//mv.addObject("FRENCH",finalrepo.FRENCH());
					mv.addObject("Kinyarwanda",finalrepo.Kinyarwanda());
					//mv.addObject("Swahili",finalrepo.Swahili());
					
					return mv;
				}
				//French
				//show Swahili
				@RequestMapping("/Swahili")
			    public ModelAndView Swahili() {
					
					ModelAndView mv = new ModelAndView("Swahili");

					//mv.addObject("English",finalrepo.English());
					//mv.addObject("FRENCH",finalrepo.FRENCH());
					//mv.addObject("Kinyarwanda",finalrepo.Kinyarwanda());
					mv.addObject("Swahili",finalrepo.Swahili());
					//English
					//java.util.List<Object[]> English =finalrepo.English();
					//English.forEach(english->System.err.println(english[0]));
					//french
					
					
					
					java.util.List<Object[]> French =finalrepo.FRENCH();
					French.forEach(french->System.out.println(french[3]));
					
		
					for(Object[] French1 : French){
						//String  val1 = String.valueOf(French1[0]); 
						String val2 = String.valueOf(French1[3]);
						
					System.out.println("french====>"+val2);
					}
					
					
		/*
		 * //Kinyarwanda java.util.List<Object[]> Kinyarwanda =finalrepo.Kinyarwanda();
		 * English.forEach(kinyarwanda->System.err.println(kinyarwanda)); //Swahili
		 * java.util.List<Object[]> Swahili =finalrepo.Swahili();
		 * English.forEach(swahili->System.err.println(swahili[0]));
		 */
					
					return mv;
				}
			
	

	

	

	@RequestMapping("/viewpage")
	public ModelAndView viewpage() {

		ModelAndView mv = new ModelAndView("view");
		mv.addObject("fieldmasterData", fieldrepo.findAll());
		mv.addObject("languagemasterData", langrepo.findAll());
		mv.addObject("webpagemasterData", webrepo.findAll());
		mv.addObject("finaltabledata",finalrepo.findAll());
		return mv;
	}
	
	//webpagemaster
	@RequestMapping("/webpagemaster")
	public String webpagemaster() {

		return "webpagemaster";
	}
	
  //save webpagedetails
	@RequestMapping("/savewebpage")
public String webpage(@RequestParam("webpageName") String webpageName,Model model) {
		
		WebpagemasterEntity webpageMaster = new WebpagemasterEntity();
		webpageMaster.setWebpageName(webpageName);
		webpageMaster.setBitStaus("0");
		webpageMaster.setCreatedBy(1);
		webpageMaster.setCreatedOn(new Date());
		webpageMaster.setUpdatedBy(1);
		webpageMaster.setUpdatedOn(new Date());
		WebpagemasterEntity webpageMaster1 =  webrepo.save(webpageMaster);
		if(webpageMaster1 != null)
		{
		model.addAttribute("Message","webpageName Saved Successfully.");
		}
		else
		{
			model.addAttribute("Message","webpageName can't save due to internal server error.");
		}
		return "webpagemaster";
	}
	
	

    //Field master
	@RequestMapping("/fieldmaster")
	public String fieldemaster() {

		return "fieldmaster";
	}
	
	//save field
	@RequestMapping("/saveField")
	public String saveField(@RequestParam("fieldName") String fieldName,Model model) {
		
		FieldmasterEntity fieldMaster = new FieldmasterEntity();
		fieldMaster.setFieldName(fieldName);
		fieldMaster.setBitStatus("0");
		fieldMaster.setCreatedBy(1);
		fieldMaster.setCreatedOn(new Date());
		fieldMaster.setUpdatedBy(1);
		fieldMaster.setUpdatedOn(new Date());
		FieldmasterEntity fieldMaster1 =  fieldrepo.save(fieldMaster);
		if(fieldMaster1 != null)
		{
		model.addAttribute("Message","Field Saved Successfully.");
		}
		else
		{
			model.addAttribute("Message","Field can't save due to internal server error.");
		}
		return "fieldmaster";
	}
	
	
	// Language master
	@RequestMapping("/languagemaster")
	public String languageMaster() {
		return "languagemaster";
	}
	
	
	//saveLanguage master
	@RequestMapping("/saveLanguage")
	public String saveLanguage(@RequestParam("languageName") String languageName,Model model) {
		
		LanguagemasterEntity languageMaster = new LanguagemasterEntity();
		languageMaster.setLanguageName(languageName);
		languageMaster.setBitStatus("0");
		languageMaster.setCreatedBy(1);
		languageMaster.setCreatedOn(new Date());
		languageMaster.setUpdatedBy(1);
		languageMaster.setUpdatedOn(new Date());
		LanguagemasterEntity languageMaster1 =  langrepo.save(languageMaster);
		if(languageMaster1 != null)
		{
		model.addAttribute("Message","Language Saved Successfully.");
		}
		else
		{
			model.addAttribute("Message","Language can't save due to internal server error.");
		}
		return "languagemaster";
	}
	
	
	 
	// Language master
	@RequestMapping("/changeLanguage")
	@ResponseBody
	public String changeLanguage(@RequestBody String encodedData) throws JSONException {
		
		
		String decodeJson = new String(Base64.getDecoder().decode(encodedData.getBytes()));
		JSONObject finalJson = new JSONObject(decodeJson);
		int langId = finalJson.getInt("LangId");
		JSONArray fieldJsa = finalJson.getJSONArray("Fields");
		// call your service and service impl
		JSONArray respJsa = new JSONArray();
		for(int i=0;i<fieldJsa.length();i++)
		{
			JSONObject json = fieldJsa.getJSONObject(i);
			String fieldId = json.getString("Field");
			FinalEntity fe = finalrepo.fetchLanguageByFieldLangId(langId,Integer.valueOf(fieldId.split("_")[1]));
			json = new JSONObject();
			json.put("FieldName",fieldId);
			json.put("FieldValue", fe.getVchfielddetails());
			respJsa.put(json);			
		}
		
		return respJsa.toString();
	}
	
}
