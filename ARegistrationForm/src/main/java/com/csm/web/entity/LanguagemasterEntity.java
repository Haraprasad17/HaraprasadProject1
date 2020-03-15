package com.csm.web.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the languagemaster database table.
 * 
 */
/*
 * @NamedQuery(name="Languagemaster.findAll",
 * query="SELECT l FROM Languagemaster l")
 */
@Entity
@Table(name = "languagemaster")
public class LanguagemasterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "intLanguageId")
	private Integer languageID;

	@Column(name = "bitstatus")
	private String bitStatus;

	@Column(name = "intCreatedBy")
	private Integer createdBy;

	@Column(name = "dtmCreatedOn")
	private Date createdOn;

	@Column(name = "vchLanguageNname")
	private String languageName;

	@Column(name = "intUpdatedBy")
	private Integer updatedBy;

	@Column(name = "dtmUpdatedOn")
	private Date updatedOn;

	 

	public Integer getLanguageID() {
		return languageID;
	}

	public String getBitStatus() {
		return this.bitStatus;
	}

	public void setBitStatus(String bitStatus) {
		this.bitStatus = bitStatus;
	}

	 

	public String getLanguageName() {
		return this.languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setLanguageID(Integer languageID) {
		this.languageID = languageID;
	}

 

	/*
	 * public List<Fieldmaster> getFieldmasters() { return this.fieldmasters; }
	 * 
	 * public void setFieldmasters(List<Fieldmaster> fieldmasters) {
	 * this.fieldmasters = fieldmasters; }
	 * 
	 * public Fieldmaster addFieldmaster(Fieldmaster fieldmaster) {
	 * getFieldmasters().add(fieldmaster); fieldmaster.setLanguagemaster(this);
	 * 
	 * return fieldmaster; }
	 * 
	 * public Fieldmaster removeFieldmaster(Fieldmaster fieldmaster) {
	 * getFieldmasters().remove(fieldmaster); fieldmaster.setLanguagemaster(null);
	 * 
	 * return fieldmaster; }
	 */

}