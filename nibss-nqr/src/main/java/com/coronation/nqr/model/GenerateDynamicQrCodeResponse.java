package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class GenerateDynamicQrCodeResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String ReturnCode;
	@JsonProperty
	 private String OrderSn;
	@JsonProperty
	 private String CodeUrl;


	 // Getter Methods 

	 public String getReturnCode() {
	  return ReturnCode;
	 }

	 public String getOrderSn() {
	  return OrderSn;
	 }

	 public String getCodeUrl() {
	  return CodeUrl;
	 }

	 // Setter Methods 

	 public void setReturnCode(String ReturnCode) {
	  this.ReturnCode = ReturnCode;
	 }

	 public void setOrderSn(String OrderSn) {
	  this.OrderSn = OrderSn;
	 }

	 public void setCodeUrl(String CodeUrl) {
	  this.CodeUrl = CodeUrl;
	 }
	
}
