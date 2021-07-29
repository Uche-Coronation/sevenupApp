package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class BatchMerchant implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String name;
	@JsonProperty
	 private String tin;
	@JsonProperty
	 private String contact;
	@JsonProperty
	 private String phone;
	@JsonProperty
	 private String email;
	@JsonProperty
	 private String bank_no;
	@JsonProperty
	 private String account_name;
	@JsonProperty
	 private String account_number;


	 // Getter Methods 

	 public String getName() {
	  return name;
	 }

	 public String getTin() {
	  return tin;
	 }

	 public String getContact() {
	  return contact;
	 }

	 public String getPhone() {
	  return phone;
	 }

	 public String getEmail() {
	  return email;
	 }

	 public String getBank_no() {
	  return bank_no;
	 }

	 public String getAccount_name() {
	  return account_name;
	 }

	 public String getAccount_number() {
	  return account_number;
	 }

	 // Setter Methods 

	 public void setName(String name) {
	  this.name = name;
	 }

	 public void setTin(String tin) {
	  this.tin = tin;
	 }

	 public void setContact(String contact) {
	  this.contact = contact;
	 }

	 public void setPhone(String phone) {
	  this.phone = phone;
	 }

	 public void setEmail(String email) {
	  this.email = email;
	 }

	 public void setBank_no(String bank_no) {
	  this.bank_no = bank_no;
	 }

	 public void setAccount_name(String account_name) {
	  this.account_name = account_name;
	 }

	 public void setAccount_number(String account_number) {
	  this.account_number = account_number;
	 }

}
