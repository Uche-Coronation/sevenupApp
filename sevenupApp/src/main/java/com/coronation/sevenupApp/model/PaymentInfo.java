package com.coronation.sevenupApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "payment_info")
public class PaymentInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@JsonProperty
	private int infoID;
	@Column
	@JsonProperty
	private String dealerCode;
	@Column
	@JsonProperty
	private String dealerName;
	@Column
	@JsonProperty
	private double amount;
	@Column
	@JsonProperty
	private double commission;
	@Column
	@JsonProperty
	private double balance;
	@Column
	@JsonProperty
	private String tellerNumber;
	@Column
	@JsonProperty
	private String paymentMode;
	@Column
	@JsonProperty
	private String transDate;
	@Column
	@JsonProperty
	private String valueDate;
	@Column
	@JsonProperty
	private String branch;
	@Column
	@JsonProperty
	private String status;
	@Column
	@JsonProperty
	private String paymentReference;
	@Column
	@JsonProperty
	private String customerRegionCode;
	@Column
	@JsonProperty
	private String customerRegionName;
	
	public int getInfoID() {
		return infoID;
	}
	public void setInfoID(int infoID) {
		this.infoID = infoID;
	}
	public String getDealerCode() {
		return dealerCode;
	}
	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getTellerNumber() {
		return tellerNumber;
	}
	public void setTellerNumber(String tellerNumber) {
		this.tellerNumber = tellerNumber;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	public String getValueDate() {
		return valueDate;
	}
	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentReference() {
		return paymentReference;
	}
	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}
	public String getCustomerRegionCode() {
		return customerRegionCode;
	}
	public void setCustomerRegionCode(String customerRegionCode) {
		this.customerRegionCode = customerRegionCode;
	}
	public String getCustomerRegionName() {
		return customerRegionName;
	}
	public void setCustomerRegionName(String customerRegionName) {
		this.customerRegionName = customerRegionName;
	}
	@Override
	public String toString() {
		return "PaymentInfo [infoID=" + infoID + ", dealerCode=" + dealerCode + ", dealerName=" + dealerName
				+ ", amount=" + amount + ", commission=" + commission + ", balance=" + balance + ", tellerNumber="
				+ tellerNumber + ", paymentMode=" + paymentMode + ", transDate=" + transDate + ", valueDate="
				+ valueDate + ", branch=" + branch + ", status=" + status + ", paymentReference=" + paymentReference
				+ "]";
	}
	
}
