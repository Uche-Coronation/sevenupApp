package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class DynamicQrCodePaymentResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String ReturnCode;
	@JsonProperty
	 private String SessionID;
	@JsonProperty
	 private String NameEnquiryRef;
	@JsonProperty
	 private String DestinationInstitutionCode;
	@JsonProperty
	 private String ChannelCode;
	@JsonProperty
	 private String BeneficiaryAccountName;
	@JsonProperty
	 private String BeneficiaryAccountNumber;
	@JsonProperty
	 private String BeneficiaryKYCLevel;
	@JsonProperty
	 private String BeneficiaryBankVerificationNumber;
	@JsonProperty
	 private String OriginatorAccountName;
	@JsonProperty
	 private String OriginatorAccountNumber;
	@JsonProperty
	 private String OriginatorBankVerificationNumber;
	@JsonProperty
	 private String OriginatorKYCLevel;
	@JsonProperty
	 private String TransactionLocation;
	@JsonProperty
	 private String Narration;
	@JsonProperty
	 private String PaymentReference;
	@JsonProperty
	 private String Amount;


	 // Getter Methods 

	 public String getReturnCode() {
	  return ReturnCode;
	 }

	 public String getSessionID() {
	  return SessionID;
	 }

	 public String getNameEnquiryRef() {
	  return NameEnquiryRef;
	 }

	 public String getDestinationInstitutionCode() {
	  return DestinationInstitutionCode;
	 }

	 public String getChannelCode() {
	  return ChannelCode;
	 }

	 public String getBeneficiaryAccountName() {
	  return BeneficiaryAccountName;
	 }

	 public String getBeneficiaryAccountNumber() {
	  return BeneficiaryAccountNumber;
	 }

	 public String getBeneficiaryKYCLevel() {
	  return BeneficiaryKYCLevel;
	 }

	 public String getBeneficiaryBankVerificationNumber() {
	  return BeneficiaryBankVerificationNumber;
	 }

	 public String getOriginatorAccountName() {
	  return OriginatorAccountName;
	 }

	 public String getOriginatorAccountNumber() {
	  return OriginatorAccountNumber;
	 }

	 public String getOriginatorBankVerificationNumber() {
	  return OriginatorBankVerificationNumber;
	 }

	 public String getOriginatorKYCLevel() {
	  return OriginatorKYCLevel;
	 }

	 public String getTransactionLocation() {
	  return TransactionLocation;
	 }

	 public String getNarration() {
	  return Narration;
	 }

	 public String getPaymentReference() {
	  return PaymentReference;
	 }

	 public String getAmount() {
	  return Amount;
	 }

	 // Setter Methods 

	 public void setReturnCode(String ReturnCode) {
	  this.ReturnCode = ReturnCode;
	 }

	 public void setSessionID(String SessionID) {
	  this.SessionID = SessionID;
	 }

	 public void setNameEnquiryRef(String NameEnquiryRef) {
	  this.NameEnquiryRef = NameEnquiryRef;
	 }

	 public void setDestinationInstitutionCode(String DestinationInstitutionCode) {
	  this.DestinationInstitutionCode = DestinationInstitutionCode;
	 }

	 public void setChannelCode(String ChannelCode) {
	  this.ChannelCode = ChannelCode;
	 }

	 public void setBeneficiaryAccountName(String BeneficiaryAccountName) {
	  this.BeneficiaryAccountName = BeneficiaryAccountName;
	 }

	 public void setBeneficiaryAccountNumber(String BeneficiaryAccountNumber) {
	  this.BeneficiaryAccountNumber = BeneficiaryAccountNumber;
	 }

	 public void setBeneficiaryKYCLevel(String BeneficiaryKYCLevel) {
	  this.BeneficiaryKYCLevel = BeneficiaryKYCLevel;
	 }

	 public void setBeneficiaryBankVerificationNumber(String BeneficiaryBankVerificationNumber) {
	  this.BeneficiaryBankVerificationNumber = BeneficiaryBankVerificationNumber;
	 }

	 public void setOriginatorAccountName(String OriginatorAccountName) {
	  this.OriginatorAccountName = OriginatorAccountName;
	 }

	 public void setOriginatorAccountNumber(String OriginatorAccountNumber) {
	  this.OriginatorAccountNumber = OriginatorAccountNumber;
	 }

	 public void setOriginatorBankVerificationNumber(String OriginatorBankVerificationNumber) {
	  this.OriginatorBankVerificationNumber = OriginatorBankVerificationNumber;
	 }

	 public void setOriginatorKYCLevel(String OriginatorKYCLevel) {
	  this.OriginatorKYCLevel = OriginatorKYCLevel;
	 }

	 public void setTransactionLocation(String TransactionLocation) {
	  this.TransactionLocation = TransactionLocation;
	 }

	 public void setNarration(String Narration) {
	  this.Narration = Narration;
	 }

	 public void setPaymentReference(String PaymentReference) {
	  this.PaymentReference = PaymentReference;
	 }

	 public void setAmount(String Amount) {
	  this.Amount = Amount;
	 }

}
