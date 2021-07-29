package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class BatchMerchantResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String Name;
	@JsonProperty
	 private String Mch_no;
	@JsonProperty
	 private String M_tin;
	@JsonProperty
	 private String State;
	@JsonProperty
	 private String Remark;


	 // Getter Methods 

	 public String getName() {
	  return Name;
	 }

	 public String getMch_no() {
	  return Mch_no;
	 }

	 public String getM_tin() {
	  return M_tin;
	 }

	 public String getState() {
	  return State;
	 }

	 public String getRemark() {
	  return Remark;
	 }

	 // Setter Methods 

	 public void setName(String Name) {
	  this.Name = Name;
	 }

	 public void setMch_no(String Mch_no) {
	  this.Mch_no = Mch_no;
	 }

	 public void setM_tin(String M_tin) {
	  this.M_tin = M_tin;
	 }

	 public void setState(String State) {
	  this.State = State;
	 }

	 public void setRemark(String Remark) {
	  this.Remark = Remark;
	 }

	
}
