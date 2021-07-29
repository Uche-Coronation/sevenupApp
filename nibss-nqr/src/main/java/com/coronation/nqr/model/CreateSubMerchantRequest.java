package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class CreateSubMerchantRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String institution_number;
	@JsonProperty
	 private String mch_no;
	@JsonProperty
	 private String name;
	@JsonProperty
	 private String email;
	@JsonProperty
	 private String phone_number;
	@JsonProperty
	 private String sub_fixed;
	@JsonProperty
	 private String sub_amount;
	@JsonProperty
	 private String timestamp;
	@JsonProperty
	 private String sign;


	 // Getter Methods 

	 public String getInstitution_number() {
	  return institution_number;
	 }

	 public String getMch_no() {
	  return mch_no;
	 }

	 public String getName() {
	  return name;
	 }

	 public String getEmail() {
	  return email;
	 }

	 public String getPhone_number() {
	  return phone_number;
	 }

	 public String getSub_fixed() {
	  return sub_fixed;
	 }

	 public String getSub_amount() {
	  return sub_amount;
	 }

	 public String getTimestamp() {
	  return timestamp;
	 }

	 public String getSign() {
	  return sign;
	 }

	 // Setter Methods 

	 public void setInstitution_number(String institution_number) {
	  this.institution_number = institution_number;
	 }

	 public void setMch_no(String mch_no) {
	  this.mch_no = mch_no;
	 }

	 public void setName(String name) {
	  this.name = name;
	 }

	 public void setEmail(String email) {
	  this.email = email;
	 }

	 public void setPhone_number(String phone_number) {
	  this.phone_number = phone_number;
	 }

	 public void setSub_fixed(String sub_fixed) {
	  this.sub_fixed = sub_fixed;
	 }

	 public void setSub_amount(String sub_amount) {
	  this.sub_amount = sub_amount;
	 }

	 public void setTimestamp(String timestamp) {
	  this.timestamp = timestamp;
	 }

	 public void setSign(String sign) {
	  this.sign = sign;
	 }

	@Override
	public String toString() {
		return "CreateSubMerchantRequest [institution_number=" + institution_number + ", mch_no=" + mch_no + ", name="
				+ name + ", email=" + email + ", phone_number=" + phone_number + ", sub_fixed=" + sub_fixed
				+ ", sub_amount=" + sub_amount + ", timestamp=" + timestamp + ", sign=" + sign + "]";
	}
	
}
