package com.coronation.sevenupApp.model;

import java.io.Serializable;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class InvoiceOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty
	private String CustomerCode;
	
	@JsonProperty
	private String InvoiceNumber;
	
	@JsonProperty
	private long SecurityCode;
	
	@JsonProperty
	private double Amount;

	public String getCustomerCode() {
		return CustomerCode;
	}

	public void setCustomerCode(String CustomerCode) {
		this.CustomerCode = CustomerCode;
	}

	public String getInvoiceNumber() {
		return InvoiceNumber;
	}

	public void setInvoiceNumber(String InvoiceNumber) {
		this.InvoiceNumber = InvoiceNumber;
	}

	public long getSecurityCode() {
		return SecurityCode;
	}

	public void setSecurityCode(long SecurityCode) {
		this.SecurityCode = SecurityCode;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double Amount) {
		this.Amount = Amount;
	}
	
}
