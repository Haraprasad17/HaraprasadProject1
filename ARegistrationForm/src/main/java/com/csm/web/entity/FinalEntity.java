package com.csm.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="final_table")
@Entity
public class FinalEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "slno")
	private int slno;
	
	@Column(name = "intwebpageid")
	private Integer webpageID;
	
	@Column(name = "intfieldid")
	private Integer intFieldId;
	
	@Column(name = "intlanguageid")
	private Integer languageID;
	
	@Column(name = "vchfielddetails")
	private String vchfielddetails;

	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}

	public Integer getWebpageID() {
		return webpageID;
	}

	public void setWebpageID(Integer webpageID) {
		this.webpageID = webpageID;
	}

	public Integer getIntFieldId() {
		return intFieldId;
	}

	public void setIntFieldId(Integer intFieldId) {
		this.intFieldId = intFieldId;
	}

	public Integer getLanguageID() {
		return languageID;
	}

	public void setLanguageID(Integer languageID) {
		this.languageID = languageID;
	}

	public String getVchfielddetails() {
		return vchfielddetails;
	}

	public void setVchfielddetails(String vchfielddetails) {
		this.vchfielddetails = vchfielddetails;
	}

	
	

}
