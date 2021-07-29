package com.coronation.sevenupApp.model;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class MainModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String BankCode;
	@JsonProperty
	private String BankAccountCode;
	@JsonProperty
	private String ProviderCode;
	@JsonProperty
	private String CustomerName;
	@JsonProperty
	private String SourceBankCode;
	@JsonProperty
	private double SBCFee;
	@JsonProperty
	private double CustomerFee;
	@JsonProperty
	private String Narration;
	@JsonProperty
	private String ChannelName;
	@JsonProperty
	private String CustomerAccountNumber;
	@JsonProperty
	private String PaymentReference;
	@JsonProperty
	private String TransactionApprovalDate;
	@JsonProperty
	private String CollectionBankCode;
	@JsonProperty
	private String CollectionBankAccountCode;
	@JsonProperty
	private String PaymentStatus;
	@JsonProperty
	private String Status;
	@JsonProperty
	private String UpdatedDate;
	@JsonProperty
	private String UpdatedBy;
	@JsonProperty
	private List<Rec> recs;
	@JsonProperty
	private String reqUuid;
	
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
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getSourceBankCode() {
		return SourceBankCode;
	}
	public void setSourceBankCode(String sourceBankCode) {
		SourceBankCode = sourceBankCode;
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
	public List<Rec> getRecs() {
		return recs;
	}
	public void setRecs(List<Rec> recs) {
		this.recs = recs;
	}
	public String getReqUuid() {
		return reqUuid;
	}
	public void setReqUuid(String reqUuid) {
		this.reqUuid = reqUuid;
	}
	
}
