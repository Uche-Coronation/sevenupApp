package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class FixedQrCodePaymentRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String channel;
	@JsonProperty
	 private String institution_number;
	@JsonProperty
	 private String mch_no;
	@JsonProperty
	 private String sub_mch_no;
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
	 private String amount;
	@JsonProperty
	 private String order_no;
	@JsonProperty
	 private String timestamp;
	@JsonProperty
	 private String sign;


	 // Getter Methods 

	 public String getChannel() {
	  return channel;
	 }

	 public String getInstitution_number() {
	  return institution_number;
	 }

	 public String getMch_no() {
	  return mch_no;
	 }

	 public String getSub_mch_no() {
	  return sub_mch_no;
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

	 public String getAmount() {
	  return amount;
	 }

	 public String getOrder_no() {
	  return order_no;
	 }

	 public String getTimestamp() {
	  return timestamp;
	 }

	 public String getSign() {
	  return sign;
	 }

	 // Setter Methods 

	 public void setChannel(String channel) {
	  this.channel = channel;
	 }

	 public void setInstitution_number(String institution_number) {
	  this.institution_number = institution_number;
	 }

	 public void setMch_no(String mch_no) {
	  this.mch_no = mch_no;
	 }

	 public void setSub_mch_no(String sub_mch_no) {
	  this.sub_mch_no = sub_mch_no;
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

	 public void setAmount(String amount) {
	  this.amount = amount;
	 }

	 public void setOrder_no(String order_no) {
	  this.order_no = order_no;
	 }

	 public void setTimestamp(String timestamp) {
	  this.timestamp = timestamp;
	 }

	 public void setSign(String sign) {
	  this.sign = sign;
	 }

	@Override
	public String toString() {
		return "FixedQrCodePaymentRequest [channel=" + channel + ", institution_number=" + institution_number
				+ ", mch_no=" + mch_no + ", sub_mch_no=" + sub_mch_no + ", user_bank_no=" + user_bank_no
				+ ", user_account_name=" + user_account_name + ", user_account_number=" + user_account_number
				+ ", user_bank_verification_number=" + user_bank_verification_number + ", user_kyc_level="
				+ user_kyc_level + ", user_gps=" + user_gps + ", amount=" + amount + ", order_no=" + order_no
				+ ", timestamp=" + timestamp + ", sign=" + sign + "]";
	}
	 
}
