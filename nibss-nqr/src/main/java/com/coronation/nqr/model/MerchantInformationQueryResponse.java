package com.coronation.nqr.model;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class MerchantInformationQueryResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String ReturnCode;
	@JsonProperty
	 private String Mch_no;
	@JsonProperty
	 private String MerchantName;
	@JsonProperty
	 private String MerchantTIN;
	@JsonProperty
	 private String MerchantAddress;
	@JsonProperty
	 private String MerchantContactName;
	@JsonProperty
	 private String MerchantPhoneNumber;
	@JsonProperty
	 private String MerchantEmail;
	@JsonProperty
	 private String MerchantAddTime;
	@JsonProperty
	 ArrayList < SubMerchant > SubMerchantList = new ArrayList < > ();


	 // Getter Methods 

	 public String getReturnCode() {
	  return ReturnCode;
	 }

	 public String getMch_no() {
	  return Mch_no;
	 }

	 public String getMerchantName() {
	  return MerchantName;
	 }

	 public String getMerchantTIN() {
	  return MerchantTIN;
	 }

	 public String getMerchantAddress() {
	  return MerchantAddress;
	 }

	 public String getMerchantContactName() {
	  return MerchantContactName;
	 }

	 public String getMerchantPhoneNumber() {
	  return MerchantPhoneNumber;
	 }

	 public String getMerchantEmail() {
	  return MerchantEmail;
	 }

	 public String getMerchantAddTime() {
	  return MerchantAddTime;
	 }

	 public ArrayList<SubMerchant> getSubMerchantList() {
			return SubMerchantList;
		}
	 
	 // Setter Methods 

	 public void setReturnCode(String ReturnCode) {
	  this.ReturnCode = ReturnCode;
	 }

	 public void setMch_no(String Mch_no) {
	  this.Mch_no = Mch_no;
	 }

	 public void setMerchantName(String MerchantName) {
	  this.MerchantName = MerchantName;
	 }

	 public void setMerchantTIN(String MerchantTIN) {
	  this.MerchantTIN = MerchantTIN;
	 }

	 public void setMerchantAddress(String MerchantAddress) {
	  this.MerchantAddress = MerchantAddress;
	 }

	 public void setMerchantContactName(String MerchantContactName) {
	  this.MerchantContactName = MerchantContactName;
	 }

	 public void setMerchantPhoneNumber(String MerchantPhoneNumber) {
	  this.MerchantPhoneNumber = MerchantPhoneNumber;
	 }

	 public void setMerchantEmail(String MerchantEmail) {
	  this.MerchantEmail = MerchantEmail;
	 }

	 public void setMerchantAddTime(String MerchantAddTime) {
	  this.MerchantAddTime = MerchantAddTime;
	 }

	public void setSubMerchantList(ArrayList<SubMerchant> subMerchantList) {
		SubMerchantList = subMerchantList;
	}

}
