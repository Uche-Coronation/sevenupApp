package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class BankCardInformationQueryResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String ReturnCode;
	@JsonProperty
	 private String SessionID;
	@JsonProperty
	 private String DestinationInstitutionCode;
	@JsonProperty
	 private String ChannelCode;
	@JsonProperty
	 private String AccountNumber;
	@JsonProperty
	 private String AccountName;
	@JsonProperty
	 private String BankVerificationNumber;
	@JsonProperty
	 private String KYCLevel;


	 // Getter Methods 

	 public String getReturnCode() {
	  return ReturnCode;
	 }

	 public String getSessionID() {
	  return SessionID;
	 }

	 public String getDestinationInstitutionCode() {
	  return DestinationInstitutionCode;
	 }

	 public String getChannelCode() {
	  return ChannelCode;
	 }

	 public String getAccountNumber() {
	  return AccountNumber;
	 }

	 public String getAccountName() {
	  return AccountName;
	 }

	 public String getBankVerificationNumber() {
	  return BankVerificationNumber;
	 }

	 public String getKYCLevel() {
	  return KYCLevel;
	 }

	 // Setter Methods 

	 public void setReturnCode(String ReturnCode) {
	  this.ReturnCode = ReturnCode;
	 }

	 public void setSessionID(String SessionID) {
	  this.SessionID = SessionID;
	 }

	 public void setDestinationInstitutionCode(String DestinationInstitutionCode) {
	  this.DestinationInstitutionCode = DestinationInstitutionCode;
	 }

	 public void setChannelCode(String ChannelCode) {
	  this.ChannelCode = ChannelCode;
	 }

	 public void setAccountNumber(String AccountNumber) {
	  this.AccountNumber = AccountNumber;
	 }

	 public void setAccountName(String AccountName) {
	  this.AccountName = AccountName;
	 }

	 public void setBankVerificationNumber(String BankVerificationNumber) {
	  this.BankVerificationNumber = BankVerificationNumber;
	 }

	 public void setKYCLevel(String KYCLevel) {
	  this.KYCLevel = KYCLevel;
	 }

	
}
