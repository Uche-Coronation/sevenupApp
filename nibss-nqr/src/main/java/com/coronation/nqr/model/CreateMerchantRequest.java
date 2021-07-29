package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class CreateMerchantRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String institution_number;
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
	 private String address;
	@JsonProperty
	 private String fee;
	@JsonProperty
	 private String timestamp;
	@JsonProperty
	 private String sign;


	 // Getter Methods 

	 public String getInstitution_number() {
	  return institution_number;
	 }

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

	 public String getAddress() {
	  return address;
	 }

	 public String getFee() {
	  return fee;
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

	 public void setAddress(String address) {
	  this.address = address;
	 }

	 public void setFee(String fee) {
	  this.fee = fee;
	 }

	 public void setTimestamp(String timestamp) {
	  this.timestamp = timestamp;
	 }

	 public void setSign(String sign) {
	  this.sign = sign;
	 }

	@Override
	public String toString() {
		return "CreateMerchantRequest [institution_number=" + institution_number + ", name=" + name + ", tin=" + tin
				+ ", contact=" + contact + ", phone=" + phone + ", email=" + email + ", address=" + address + ", fee="
				+ fee + ", timestamp=" + timestamp + ", sign=" + sign + "]";
	}

}
