package com.coronation.sevenupApp.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class ValidationResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty
	private String CustomerCode;
	
	@JsonProperty
	private String InvoiceNumber;
	
	@JsonProperty
	private double Amount;
	
	@JsonProperty
	private String CustomerRegionCode;
	
	@JsonProperty
	private String CustomerRegionName;
	
	@JsonProperty
	private String ExecutionId;

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

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public String getCustomerRegionCode() {
		return CustomerRegionCode;
	}

	public void setCustomerRegionCode(String customerRegionCode) {
		CustomerRegionCode = customerRegionCode;
	}

	public String getCustomerRegionName() {
		return CustomerRegionName;
	}

	public void setCustomerRegionName(String customerRegionName) {
		CustomerRegionName = customerRegionName;
	}

	public String getExecutionId() {
		return ExecutionId;
	}

	public void setExecutionId(String executionId) {
		ExecutionId = executionId;
	}
	
}
