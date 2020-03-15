package com.csm.web.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the fieldmaster database table.
 * 
 */
@Entity
@Table(name="fieldmaster")
/*@NamedQuery(name="Fieldmaster.findAll", query="SELECT f FROM Fieldmaster f")*/
public class FieldmasterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "int_fieldid")
	private Integer fieldID;
	
	@Column(name = "bit_status")
	private String bitStatus;
	
	@Column(name = "int_created_by")
	private Integer createdBy;
	
	@Column(name = "dtm_created_on")
	private Date createdOn;
    
	@Column(name = "vch_field_name")
	private String fieldName;
    
	@Column(name = "int_updated_by")
	private Integer updatedBy;

	@Column(name = "dtm_updated_on")
	private Date updatedOn;

	public Integer getFieldID() {
		return fieldID;
	}

	public void setFieldID(Integer fieldID) {
		this.fieldID = fieldID;
	}

	public String getBitStatus() {
		return bitStatus;
	}

	public void setBitStatus(String bitStatus) {
		this.bitStatus = bitStatus;
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

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
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

	

	//bi-directional many-to-one association to Languagemaster
	/*@ManyToOne
	@JoinColumns({
		})*/
	/*private Languagemaster languagemaster;

	public Fieldmaster() {
	}*/

	
	/*public Languagemaster getLanguagemaster() {
		return this.languagemaster;
	}

	public void setLanguagemaster(Languagemaster languagemaster) {
		this.languagemaster = languagemaster;
	}*/

}