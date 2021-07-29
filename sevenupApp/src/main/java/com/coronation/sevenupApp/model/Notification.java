package com.coronation.sevenupApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class Notification implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty
	@Column
	private String CustomerCode;
	
	@JsonProperty
	@Column
	private String CustomerName;
	
	@JsonProperty
	@Column
	private String InvoiceNumber;
	
	@JsonProperty
	@Column
	private String SecurityCode;
	
	@JsonProperty
	@Column
	private String SourceBankCode;
	
	@JsonProperty
	@Column
	private String ExecutionId;
	
	@JsonProperty
	@Column
	private double SBCFee;
	
	@JsonProperty
	@Column
	private double CustomerFee;
	
	@JsonProperty
	@Column
	private double Amount;
	
	@JsonProperty
	@Column
	private double TotalAmount;
	
	@JsonProperty
	@Column
	private String Narration;
	
	@JsonProperty
	@Column
	private String ChannelName;
	
	@JsonProperty
	@Column
	private String CustomerAccountNumber;
	
	@JsonProperty
	@Id
	private String PaymentReference;
	
	@JsonProperty
	private String TransactionApprovalDate;
	
	@JsonProperty
	@Column
	private String ProviderCode;
	
	@JsonProperty
	@Column
	private String CollectionBankCode;
	
	@JsonProperty
	@Column
	private String CollectionBankAccountCode;
	
	@JsonProperty
    @Column
	private String PaymentStatus;
	
	@JsonProperty
	@Column
	private String Status;
	
	@JsonProperty
	@Column
	private String UpdatedDate;
	
	@JsonProperty
	@Column
	private String UpdatedBy;

	public String getCustomerCode() {
		return CustomerCode;
	}

	public void setCustomerCode(String customerCode) {
		CustomerCode = customerCode;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
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

	public String getSourceBankCode() {
		return SourceBankCode;
	}

	public void setSourceBankCode(String sourceBankCode) {
		SourceBankCode = sourceBankCode;
	}

	public String getExecutionId() {
		return ExecutionId;
	}

	public void setExecutionId(String executionId) {
		ExecutionId = executionId;
	}

	public double getSBCFee() {
		return SBCFee;
	}

	public void setSBCFee(double sBCFee) {
		SBCFee = sBCFee;
	}

	public double getCustomerFee() {
		return CustomerFee;
	}

	public void setCustomerFee(double customerFee) {
		CustomerFee = customerFee;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public double getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}

	public String getNarration() {
		return Narration;
	}

	public void setNarration(String narration) {
		Narration = narration;
	}

	public String getChannelName() {
		return ChannelName;
	}

	public void setChannelName(String channelName) {
		ChannelName = channelName;
	}

	public String getCustomerAccountNumber() {
		return CustomerAccountNumber;
	}

	public void setCustomerAccountNumber(String customerAccountNumber) {
		CustomerAccountNumber = customerAccountNumber;
	}

	public String getPaymentReference() {
		return PaymentReference;
	}

	public void setPaymentReference(String paymentReference) {
		PaymentReference = paymentReference;
	}

	public String getTransactionApprovalDate() {
		return TransactionApprovalDate;
	}

	public void setTransactionApprovalDate(String transactionApprovalDate) {
		TransactionApprovalDate = transactionApprovalDate;
	}

	public String getProviderCode() {
		return ProviderCode;
	}

	public void setProviderCode(String providerCode) {
		ProviderCode = providerCode;
	}

	public String getCollectionBankCode() {
		return CollectionBankCode;
	}

	public void setCollectionBankCode(String collectionBankCode) {
		CollectionBankCode = collectionBankCode;
	}

	public String getCollectionBankAccountCode() {
		return CollectionBankAccountCode;
	}

	public void setCollectionBankAccountCode(String collectionBankAccountCode) {
		CollectionBankAccountCode = collectionBankAccountCode;
	}

	public String getPaymentStatus() {
		return PaymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		PaymentStatus = paymentStatus;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getUpdatedDate() {
		return UpdatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		UpdatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return UpdatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		UpdatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "Notification [CustomerCode=" + CustomerCode + ", CustomerName=" + CustomerName + ", InvoiceNumber="
				+ InvoiceNumber + ", SecurityCode=" + SecurityCode + ", SourceBankCode=" + SourceBankCode
				+ ", ExecutionId=" + ExecutionId + ", SBCFee=" + SBCFee + ", CustomerFee=" + CustomerFee + ", Amount="
				+ Amount + ", TotalAmount=" + TotalAmount + ", Narration=" + Narration + ", ChannelName=" + ChannelName
				+ ", CustomerAccountNumber=" + CustomerAccountNumber + ", PaymentReference=" + PaymentReference
				+ ", TransactionApprovalDate=" + TransactionApprovalDate + ", ProviderCode=" + ProviderCode
				+ ", CollectionBankCode=" + CollectionBankCode + ", CollectionBankAccountCode="
				+ CollectionBankAccountCode + ", PaymentStatus=" + PaymentStatus + ", Status=" + Status
				+ ", UpdatedDate=" + UpdatedDate + ", UpdatedBy=" + UpdatedBy + "]";
	}

}
