package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class DynamicQrCodeQueryResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String ReturnCode;
	@JsonProperty
	 private String MerchantName;
	@JsonProperty
	 private String SubMerchantName;
	@JsonProperty
	 private String Mch_no;
	@JsonProperty
	 private String Sub_mch_no;


	 // Getter Methods 

	 public String getReturnCode() {
	  return ReturnCode;
	 }

	 public String getMerchantName() {
	  return MerchantName;
	 }

	 public String getSubMerchantName() {
	  return SubMerchantName;
	 }

	 public String getMch_no() {
	  return Mch_no;
	 }

	 public String getSub_mch_no() {
	  return Sub_mch_no;
	 }

	 // Setter Methods 

	 public void setReturnCode(String ReturnCode) {
	  this.ReturnCode = ReturnCode;
	 }

	 public void setMerchantName(String MerchantName) {
	  this.MerchantName = MerchantName;
	 }

	 public void setSubMerchantName(String SubMerchantName) {
	  this.SubMerchantName = SubMerchantName;
	 }

	 public void setMch_no(String Mch_no) {
	  this.Mch_no = Mch_no;
	 }

	 public void setSub_mch_no(String Sub_mch_no) {
	  this.Sub_mch_no = Sub_mch_no;
	 }

}
