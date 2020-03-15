package com.csm.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csm.web.entity.FinalEntity;
@Repository
public interface FinalRepository extends CrudRepository<FinalEntity, Integer> {

	@Query(value="select fm.vch_field_name,lm.vch_language_nname,wm.vch_webpage_name,ft.vchFieldDetails,ft.slno from final_table ft\r\n" + 
			"left join fieldmaster fm on fm.int_fieldid = ft.intFieldId\r\n" + 
			"left join languagemaster lm on lm.int_language_id = ft.intLanguageId\r\n" + 
			"left join webpagemaster wm on wm.int_webpageid = ft.intWebPageId",nativeQuery=true)
	List<Object[]> AllRequiredInformation();
	
	//for English data
	@Query(value="select fm.vch_field_name,lm.vch_language_nname,wm.vch_webpage_name,ft.vchFieldDetails,ft.slno from final_table ft\r\n" + 
			"left join fieldmaster fm on fm.int_fieldid = ft.intFieldId\r\n" + 
			"left join languagemaster lm on lm.int_language_id = ft.intLanguageId\r\n" + 
			"left join webpagemaster wm on wm.int_webpageid = ft.intWebPageId\r\n" + 
			"\r\n" + 
			"where ft.intLanguageId = 1;",nativeQuery=true)
	List<Object[]> English();
	
	
	//for French data
		@Query(value="select fm.vch_field_name,lm.vch_language_nname,wm.vch_webpage_name,ft.vchFieldDetails,ft.slno from final_table ft\r\n" + 
				"left join fieldmaster fm on fm.int_fieldid = ft.intFieldId\r\n" + 
				"left join languagemaster lm on lm.int_language_id = ft.intLanguageId\r\n" + 
				"left join webpagemaster wm on wm.int_webpageid = ft.intWebPageId\r\n" + 
				"\r\n" + 
				"where ft.intLanguageId = 2;",nativeQuery=true)
		List<Object[]> FRENCH();
		
		//for Kinyarwanda data
		@Query(value="select fm.vch_field_name,lm.vch_language_nname,wm.vch_webpage_name,ft.vchFieldDetails,ft.slno from final_table ft\r\n" + 
				"left join fieldmaster fm on fm.int_fieldid = ft.intFieldId\r\n" + 
				"left join languagemaster lm on lm.int_language_id = ft.intLanguageId\r\n" + 
				"left join webpagemaster wm on wm.int_webpageid = ft.intWebPageId\r\n" + 
				"\r\n" + 
				"where ft.intLanguageId = 3;",nativeQuery=true)
		List<Object[]> Kinyarwanda();
	
		//for Swahili data
				@Query(value="select fm.vch_field_name,lm.vch_language_nname,wm.vch_webpage_name,ft.vchFieldDetails,ft.slno from final_table ft\r\n" + 
						"left join fieldmaster fm on fm.int_fieldid = ft.intFieldId\r\n" + 
						"left join languagemaster lm on lm.int_language_id = ft.intLanguageId\r\n" + 
						"left join webpagemaster wm on wm.int_webpageid = ft.intWebPageId\r\n" + 
						"\r\n" + 
						"where ft.intLanguageId = 4;",nativeQuery=true)
				List<Object[]> Swahili();

				@Query("FROM FinalEntity where languageID = ?1 and intFieldId = ?2")
				FinalEntity fetchLanguageByFieldLangId(Integer langId, Integer string);
			
	
	
	
	
	
	
	
}
