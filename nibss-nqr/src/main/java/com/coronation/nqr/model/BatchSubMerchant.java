package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class BatchSubMerchant implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String sub_name;
	@JsonProperty
	 private String sub_email;
	@JsonProperty
	 private String sub_phone_number;
	@JsonProperty
	 private String sub_fixed;
	@JsonProperty
	 private String sub_amount;


	 // Getter Methods 

	 public String getSub_name() {
	  return sub_name;
	 }

	 public String getSub_email() {
	  return sub_email;
	 }

	 public String getSub_phone_number() {
	  return sub_phone_number;
	 }

	 public String getSub_fixed() {
	  return sub_fixed;
	 }

	 public String getSub_amount() {
	  return sub_amount;
	 }

	 // Setter Methods 

	 public void setSub_name(String sub_name) {
	  this.sub_name = sub_name;
	 }

	 public void setSub_email(String sub_email) {
	  this.sub_email = sub_email;
	 }

	 public void setSub_phone_number(String sub_phone_number) {
	  this.sub_phone_number = sub_phone_number;
	 }

	 public void setSub_fixed(String sub_fixed) {
	  this.sub_fixed = sub_fixed;
	 }

	 public void setSub_amount(String sub_amount) {
	  this.sub_amount = sub_amount;
	 }

	
}
