package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class TransferTransactionRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String institution_number;
	@JsonProperty
	 private String channel;
	@JsonProperty
	 private String amount;
	@JsonProperty
	 private String order_no;
	@JsonProperty
	 private String order_type;
	@JsonProperty
	 private String payee_bank_no;
	@JsonProperty
	 private String payee_account_name;
	@JsonProperty
	 private String payee_account_number;
	@JsonProperty
	 private String payee_bank_verification_number;
	@JsonProperty
	 private String payee_kyc_level;
	@JsonProperty
	 private String payer_bank_no;
	@JsonProperty
	 private String payer_account_name;
	@JsonProperty
	 private String payer_account_number;
	@JsonProperty
	 private String payer_bank_verification_number;
	@JsonProperty
	 private String payer_kyc_level;
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

	 public String getChannel() {
	  return channel;
	 }

	 public String getAmount() {
	  return amount;
	 }

	 public String getOrder_no() {
	  return order_no;
	 }

	 public String getOrder_type() {
	  return order_type;
	 }

	 public String getPayee_bank_no() {
	  return payee_bank_no;
	 }

	 public String getPayee_account_name() {
	  return payee_account_name;
	 }

	 public String getPayee_account_number() {
	  return payee_account_number;
	 }

	 public String getPayee_bank_verification_number() {
	  return payee_bank_verification_number;
	 }

	 public String getPayee_kyc_level() {
	  return payee_kyc_level;
	 }

	 public String getPayer_bank_no() {
	  return payer_bank_no;
	 }

	 public String getPayer_account_name() {
	  return payer_account_name;
	 }

	 public String getPayer_account_number() {
	  return payer_account_number;
	 }

	 public String getPayer_bank_verification_number() {
	  return payer_bank_verification_number;
	 }

	 public String getPayer_kyc_level() {
	  return payer_kyc_level;
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

	 public void setChannel(String channel) {
	  this.channel = channel;
	 }

	 public void setAmount(String amount) {
	  this.amount = amount;
	 }

	 public void setOrder_no(String order_no) {
	  this.order_no = order_no;
	 }

	 public void setOrder_type(String order_type) {
	  this.order_type = order_type;
	 }

	 public void setPayee_bank_no(String payee_bank_no) {
	  this.payee_bank_no = payee_bank_no;
	 }

	 public void setPayee_account_name(String payee_account_name) {
	  this.payee_account_name = payee_account_name;
	 }

	 public void setPayee_account_number(String payee_account_number) {
	  this.payee_account_number = payee_account_number;
	 }

	 public void setPayee_bank_verification_number(String payee_bank_verification_number) {
	  this.payee_bank_verification_number = payee_bank_verification_number;
	 }

	 public void setPayee_kyc_level(String payee_kyc_level) {
	  this.payee_kyc_level = payee_kyc_level;
	 }

	 public void setPayer_bank_no(String payer_bank_no) {
	  this.payer_bank_no = payer_bank_no;
	 }

	 public void setPayer_account_name(String payer_account_name) {
	  this.payer_account_name = payer_account_name;
	 }

	 public void setPayer_account_number(String payer_account_number) {
	  this.payer_account_number = payer_account_number;
	 }

	 public void setPayer_bank_verification_number(String payer_bank_verification_number) {
	  this.payer_bank_verification_number = payer_bank_verification_number;
	 }

	 public void setPayer_kyc_level(String payer_kyc_level) {
	  this.payer_kyc_level = payer_kyc_level;
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

	@Override
	public String toString() {
		return "TransferTransactionRequest [institution_number=" + institution_number + ", channel=" + channel
				+ ", amount=" + amount + ", order_no=" + order_no + ", order_type=" + order_type + ", payee_bank_no="
				+ payee_bank_no + ", payee_account_name=" + payee_account_name + ", payee_account_number="
				+ payee_account_number + ", payee_bank_verification_number=" + payee_bank_verification_number
				+ ", payee_kyc_level=" + payee_kyc_level + ", payer_bank_no=" + payer_bank_no + ", payer_account_name="
				+ payer_account_name + ", payer_account_number=" + payer_account_number
				+ ", payer_bank_verification_number=" + payer_bank_verification_number + ", payer_kyc_level="
				+ payer_kyc_level + ", user_gps=" + user_gps + ", timestamp=" + timestamp + ", sign=" + sign + "]";
	}

}
