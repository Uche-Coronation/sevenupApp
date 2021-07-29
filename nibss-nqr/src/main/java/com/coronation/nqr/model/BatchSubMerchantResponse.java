package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class BatchSubMerchantResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	 private String Sub_name;
	@JsonProperty
	 private String Sub_mch_no;
	@JsonProperty
	 private String Emvco_code;


	 // Getter Methods 

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
