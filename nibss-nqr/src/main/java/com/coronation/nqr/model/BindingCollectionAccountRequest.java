package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class BindingCollectionAccountRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String institution_number;
	@JsonProperty
	 private String mch_no;
	@JsonProperty
	 private String bank_no;
	@JsonProperty
	 private String account_name;
	@JsonProperty
	 private String account_number;
	@JsonProperty
	 private String timestamp;
	@JsonProperty
	 private String sign;


	 // Getter Methods 

	 public String getInstitution_number() {
	  return institution_number;
	 }

	 public String getMch_no() {
	  return mch_no;
	 }

	 public String getBank_no() {
	  return bank_no;
	 }

	 public String getAccount_name() {
	  return account_name;
	 }

	 public String getAccount_number() {
	  return account_number;
	 }

	 public String getTimestamp() {
	  return timestamp;
	 }

	 public String getSign() {
	  return sign;
	 }

	 // Setter Methods 

	 public void setInstitution_number(String institution_number) {
	  this.institution_number = institution_number;
	 }

	 public void setMch_no(String mch_no) {
	  this.mch_no = mch_no;
	 }

	 public void setBank_no(String bank_no) {
	  this.bank_no = bank_no;
	 }

	 public void setAccount_name(String account_name) {
	  this.account_name = account_name;
	 }

	 public void setAccount_number(String account_number) {
	  this.account_number = account_number;
	 }

	 public void setTimestamp(String timestamp) {
	  this.timestamp = timestamp;
	 }

	 public void setSign(String sign) {
	  this.sign = sign;
	 }

	@Override
	public String toString() {
		return "BindingCollectionAccountRequest [institution_number=" + institution_number + ", mch_no=" + mch_no
				+ ", bank_no=" + bank_no + ", account_name=" + account_name + ", account_number=" + account_number
				+ ", timestamp=" + timestamp + ", sign=" + sign + "]";
	}

}
