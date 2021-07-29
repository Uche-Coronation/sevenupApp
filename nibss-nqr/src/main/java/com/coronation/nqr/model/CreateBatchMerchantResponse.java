package com.coronation.nqr.model;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class CreateBatchMerchantResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@JsonProperty
	private String ReturnCode;
	@JsonProperty
	 private String InstitutionNumber;
	@JsonProperty
	 ArrayList <BatchMerchantResponse> List = new ArrayList <> ();


	 // Getter Methods 

	 public String getReturnCode() {
	  return ReturnCode;
	 }

	 public String getInstitutionNumber() {
	  return InstitutionNumber;
	 }

	 public ArrayList<BatchMerchantResponse> getList() {
			return List;
		}
	 
	 // Setter Methods 

	public void setList(ArrayList<BatchMerchantResponse> list) {
		List = list;
	}

	public void setReturnCode(String ReturnCode) {
	  this.ReturnCode = ReturnCode;
	 }

	 public void setInstitutionNumber(String InstitutionNumber) {
	  this.InstitutionNumber = InstitutionNumber;
	 }
	
}
