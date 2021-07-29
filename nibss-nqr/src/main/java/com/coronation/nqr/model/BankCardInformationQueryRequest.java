package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class BankCardInformationQueryRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@JsonProperty
	private String institution_number;
	@JsonProperty
	 private String channel;
	@JsonProperty
	 private String bank_number;
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

	 public String getChannel() {
	  return channel;
	 }

	 public String getBank_number() {
	  return bank_number;
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

	 public void setChannel(String channel) {
	  this.channel = channel;
	 }

	 public void setBank_number(String bank_number) {
	  this.bank_number = bank_number;
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
		return "BankCardInformationQueryRequest [institution_number=" + institution_number + ", channel=" + channel
				+ ", bank_number=" + bank_number + ", account_number=" + account_number + ", timestamp=" + timestamp
				+ ", sign=" + sign + "]";
	}

	
}
