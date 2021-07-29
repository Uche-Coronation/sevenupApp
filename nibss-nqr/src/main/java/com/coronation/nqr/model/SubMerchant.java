package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class SubMerchant implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String Sub_name;
	@JsonProperty
	private String Sub_no;
	@JsonProperty
	private String Emvco_code;
	
	public String getSub_name() {
		return Sub_name;
	}
	public void setSub_name(String sub_name) {
		Sub_name = sub_name;
	}
	public String getSub_no() {
		return Sub_no;
	}
	public void setSub_no(String sub_no) {
		Sub_no = sub_no;
	}
	public String getEmvco_code() {
		return Emvco_code;
	}
	public void setEmvco_code(String emvco_code) {
		Emvco_code = emvco_code;
	}
	
}
