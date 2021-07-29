package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class FailResponse implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	 private String ReturnCode;
	 @JsonProperty
	 private String ReturnMsg;


	 // Getter Methods 

	 public String getReturnCode() {
	  return ReturnCode;
	 }

	 public String getReturnMsg() {
	  return ReturnMsg;
	 }

	 // Setter Methods 

	 public void setReturnCode(String ReturnCode) {
	  this.ReturnCode = ReturnCode;
	 }

	 public void setReturnMsg(String ReturnMsg) {
	  this.ReturnMsg = ReturnMsg;
	 }
	
}
