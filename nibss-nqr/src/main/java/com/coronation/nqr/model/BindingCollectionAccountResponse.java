package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class BindingCollectionAccountResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@JsonProperty
	private String ReturnCode;
	@JsonProperty
	 private String InstitutionNumber;
	@JsonProperty
	 private String Mch_no;


	 // Getter Methods 

	 public String getReturnCode() {
	  return ReturnCode;
	 }

	 public String getInstitutionNumber() {
	  return InstitutionNumber;
	 }

	 public String getMch_no() {
	  return Mch_no;
	 }

	 // Setter Methods 

	 public void setReturnCode(String ReturnCode) {
	  this.ReturnCode = ReturnCode;
	 }

	 public void setInstitutionNumber(String InstitutionNumber) {
	  this.InstitutionNumber = InstitutionNumber;
	 }

	 public void setMch_no(String Mch_no) {
	  this.Mch_no = Mch_no;
	 }
	
}
