package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class DynamicQrCodePaymentRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String institution_number;
	@JsonProperty
	 private String order_sn;
	@JsonProperty
	private String order_amount;
	@JsonProperty
	 private String user_bank_no;
	@JsonProperty
	 private String user_account_name;
	@JsonProperty
	 private String user_account_number;
	@JsonProperty
	 private String user_bank_verification_number;
	@JsonProperty
	 private String user_kyc_level;
	@JsonProperty
	 private String user_gps;
	@JsonProperty
	 private String timestamp;
	@JsonProperty
	 private String sign;


	 // Getter Methods 

	 public String getInstitution_number() {
	  return institution_number;
	 }

	 public String getOrder_sn() {
	  return order_sn;
	 }

	 public String getUser_bank_no() {
	  return user_bank_no;
	 }

	 public String getUser_account_name() {
	  return user_account_name;
	 }

	 public String getUser_account_number() {
	  return user_account_number;
	 }

	 public String getUser_bank_verification_number() {
	  return user_bank_verification_number;
	 }

	 public String getUser_kyc_level() {
	  return user_kyc_level;
	 }

	 public String getUser_gps() {
	  return user_gps;
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

	 public void setOrder_sn(String order_sn) {
	  this.order_sn = order_sn;
	 }

	 public void setUser_bank_no(String user_bank_no) {
	  this.user_bank_no = user_bank_no;
	 }

	 public void setUser_account_name(String user_account_name) {
	  this.user_account_name = user_account_name;
	 }

	 public void setUser_account_number(String user_account_number) {
	  this.user_account_number = user_account_number;
	 }

	 public void setUser_bank_verification_number(String user_bank_verification_number) {
	  this.user_bank_verification_number = user_bank_verification_number;
	 }

	 public void setUser_kyc_level(String user_kyc_level) {
	  this.user_kyc_level = user_kyc_level;
	 }

	 public void setUser_gps(String user_gps) {
	  this.user_gps = user_gps;
	 }

	 public void setTimestamp(String timestamp) {
	  this.timestamp = timestamp;
	 }

	 public void setSign(String sign) {
	  this.sign = sign;
	 }

	public String getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(String order_amount) {
		this.order_amount = order_amount;
	}

	@Override
	public String toString() {
		return "DynamicQrCodePaymentRequest [institution_number=" + institution_number + ", order_sn=" + order_sn
				+ ", order_amount=" + order_amount + ", user_bank_no=" + user_bank_no + ", user_account_name="
				+ user_account_name + ", user_account_number=" + user_account_number
				+ ", user_bank_verification_number=" + user_bank_verification_number + ", user_kyc_level="
				+ user_kyc_level + ", user_gps=" + user_gps + ", timestamp=" + timestamp + ", sign=" + sign + "]";
	}

}
