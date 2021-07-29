package com.coronation.nqr.model;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class CreateBatchSubMerchantRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@JsonProperty
	private String institution_number;
	@JsonProperty
	 private String mch_no;
	@JsonProperty
	 private String timestamp;
	@JsonProperty
	 private String sign;
	@JsonProperty
	 ArrayList<BatchSubMerchant> list = new ArrayList<>();


	 // Getter Methods 

	 public String getInstitution_number() {
	  return institution_number;
	 }

	 public String getMch_no() {
	  return mch_no;
	 }

	 public String getTimestamp() {
	  return timestamp;
	 }

	 public String getSign() {
	  return sign;
	 }

	 public ArrayList<BatchSubMerchant> getList() {
			return list;
		}
	 
	 // Setter Methods 

	public void setList(ArrayList<BatchSubMerchant> list) {
		this.list = list;
	}

	public void setInstitution_number(String institution_number) {
	  this.institution_number = institution_number;
	 }

	 public void setMch_no(String mch_no) {
	  this.mch_no = mch_no;
	 }

	 public void setTimestamp(String timestamp) {
	  this.timestamp = timestamp;
	 }

	 public void setSign(String sign) {
	  this.sign = sign;
	 }

	@Override
	public String toString() {
		return "CreateBatchSubMerchantRequest [institution_number=" + institution_number + ", mch_no=" + mch_no
				+ ", timestamp=" + timestamp + ", sign=" + sign + ", list=" + list + "]";
	}

}
