package com.coronation.sevenupApp.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class ValidationRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty
	private String CustomerCode;
	
	@JsonProperty
	private String InvoiceNumber;
	
	@JsonProperty
	private String SecurityCode;
	
	@JsonProperty
	private double Amount;
	
	@JsonProperty
	private String BankCode;
	
	@JsonProperty
	private String BankAccountCode;
	
	@JsonProperty
	private String ProviderCode;

	public String getCustomerCode() {
		return CustomerCode;
	}

	public void setCustomerCode(String customerCode) {
		CustomerCode = customerCode;
	}

	public String getInvoiceNumber() {
		return InvoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		InvoiceNumber = invoiceNumber;
	}

	public String getSecurityCode() {
		return SecurityCode;
	}

	public void setSecurityCode(String securityCode) {
		SecurityCode = securityCode;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public String getBankCode() {
		return BankCode;
	}

	public void setBankCode(String bankCode) {
		BankCode = bankCode;
	}

	public String getBankAccountCode() {
		return BankAccountCode;
	}

	public void setBankAccountCode(String bankAccountCode) {
		BankAccountCode = bankAccountCode;
	}

	public String getProviderCode() {
		return ProviderCode;
	}

	public void setProviderCode(String providerCode) {
		ProviderCode = providerCode;
	}
	
}
