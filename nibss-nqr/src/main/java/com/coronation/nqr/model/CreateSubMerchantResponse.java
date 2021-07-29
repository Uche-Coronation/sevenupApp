package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class CreateSubMerchantResponse implements Serializable{

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
	@JsonProperty
	 private String Sub_name;
	@JsonProperty
	 private String Sub_mch_no;
	@JsonProperty
	 private String Emvco_code;


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

	 public String getSub_name() {
	  return Sub_name;
	 }

	 public String getSub_mch_no() {
	  return Sub_mch_no;
	 }

	 public String getEmvco_code() {
	  return Emvco_code;
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

	 public void setSub_name(String Sub_name) {
	  this.Sub_name = Sub_name;
	 }

	 public void setSub_mch_no(String Sub_mch_no) {
	  this.Sub_mch_no = Sub_mch_no;
	 }

	 public void setEmvco_code(String Emvco_code) {
	  this.Emvco_code = Emvco_code;
	 }

	
}
