package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class TransactionFeeResponse implements Serializable{

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
	private String TransactionAmount;
	@JsonProperty
	private String Fee;
	@JsonProperty
	private String VAT;
	@JsonProperty
	private String Borne;
	@JsonProperty
	private String PaymentAmount;
	@JsonProperty
	private String TransactionType;
	
	public String getReturnCode() {
		return ReturnCode;
	}
	public void setReturnCode(String returnCode) {
		ReturnCode = returnCode;
	}
	public String getMerchantName() {
		return MerchantName;
	}
	public void setMerchantName(String merchantName) {
		MerchantName = merchantName;
	}
	public String getSubMerchantName() {
		return SubMerchantName;
	}
	public void setSubMerchantName(String subMerchantName) {
		SubMerchantName = subMerchantName;
	}
	public String getTransactionAmount() {
		return TransactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		TransactionAmount = transactionAmount;
	}
	public String getFee() {
		return Fee;
	}
	public void setFee(String fee) {
		Fee = fee;
	}
	public String getVAT() {
		return VAT;
	}
	public void setVAT(String vAT) {
		VAT = vAT;
	}
	public String getBorne() {
		return Borne;
	}
	public void setBorne(String borne) {
		Borne = borne;
	}
	public String getPaymentAmount() {
		return PaymentAmount;
	}
	public void setPaymentAmount(String paymentAmount) {
		PaymentAmount = paymentAmount;
	}
	public String getTransactionType() {
		return TransactionType;
	}
	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}
	
}
