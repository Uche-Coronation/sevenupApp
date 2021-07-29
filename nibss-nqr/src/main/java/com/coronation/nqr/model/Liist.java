package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class Liist implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String InstitutionName;
	@JsonProperty
	 private String MerchantName;
	@JsonProperty
	 private String SubMerchantName;
	@JsonProperty
	 private String Amount;
	@JsonProperty
	 private String Time;
	@JsonProperty
	 private String OrderSn;
	@JsonProperty
	 private String OrderNo;
	@JsonProperty
	 private String OrderType;


	 // Getter Methods 

	 public String getInstitutionName() {
	  return InstitutionName;
	 }

	 public String getMerchantName() {
	  return MerchantName;
	 }

	 public String getSubMerchantName() {
	  return SubMerchantName;
	 }

	 public String getAmount() {
	  return Amount;
	 }

	 public String getTime() {
	  return Time;
	 }

	 public String getOrderSn() {
	  return OrderSn;
	 }

	 public String getOrderNo() {
	  return OrderNo;
	 }

	 public String getOrderType() {
	  return OrderType;
	 }

	 // Setter Methods 

	 public void setInstitutionName(String InstitutionName) {
	  this.InstitutionName = InstitutionName;
	 }

	 public void setMerchantName(String MerchantName) {
	  this.MerchantName = MerchantName;
	 }

	 public void setSubMerchantName(String SubMerchantName) {
	  this.SubMerchantName = SubMerchantName;
	 }

	 public void setAmount(String Amount) {
	  this.Amount = Amount;
	 }

	 public void setTime(String Time) {
	  this.Time = Time;
	 }

	 public void setOrderSn(String OrderSn) {
	  this.OrderSn = OrderSn;
	 }

	 public void setOrderNo(String OrderNo) {
	  this.OrderNo = OrderNo;
	 }

	 public void setOrderType(String OrderType) {
	  this.OrderType = OrderType;
	 }
	 
	}

