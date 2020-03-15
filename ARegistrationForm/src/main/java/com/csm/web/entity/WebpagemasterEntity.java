package com.csm.web.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the webpagemaster database table.
 * 
 */
@Entity
@Table(name = "webpagemaster")
/*@NamedQuery(name="Webpagemaster.findAll", query="SELECT w FROM Webpagemaster w")*/
public class WebpagemasterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "int_webpageid")
	private Integer webpageID;
	
	@Column(name = "bit_status")
	private String bitStaus;
	
	@Column(name = "int_created_by")
	private Integer createdBy;
	
	@Column(name = "dtm_created_on")
	private Date createdOn;
	
	@Column(name = "int_updated_by")
	private Integer updatedBy;
	
	@Column(name = "dtm_updated_on")
	private Date updatedOn;
	
	@Column(name = "vch_webpage_name")
	private String webpageName;

	public Integer getWebpageID() {
		return webpageID;
	}

	public void setWebpageID(Integer webpageID) {
		this.webpageID = webpageID;
	}

	
	public String getBitStaus() {
		return bitStaus;
	}

	public void setBitStaus(String bitStaus) {
		this.bitStaus = bitStaus;
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

	public String getWebpageName() {
		return webpageName;
	}

	public void setWebpageName(String webpageName) {
		this.webpageName = webpageName;
	}


}