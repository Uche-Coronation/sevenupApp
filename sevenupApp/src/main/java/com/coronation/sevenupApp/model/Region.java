package com.coronation.sevenupApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Region {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long regionID;
	@Column
	private String regionName;
	@Column
	private String regionCode;
	public Long getRegionID() {
		return regionID;
	}
	public void setRegionID(Long regionID) {
		this.regionID = regionID;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	
}
