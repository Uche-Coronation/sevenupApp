package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class MerchantTransactionRecordQueryRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String institution_number;
	@JsonProperty
	 private String mch_no;
	@JsonProperty
	 private String start_time;
	@JsonProperty
	 private String end_time;
	@JsonProperty
	 private String order_type;
	@JsonProperty
	 private String page;
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

	 public String getStart_time() {
	  return start_time;
	 }

	 public String getEnd_time() {
	  return end_time;
	 }

	 public String getOrder_type() {
	  return order_type;
	 }

	 public String getPage() {
	  return page;
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

	 public void setStart_time(String start_time) {
	  this.start_time = start_time;
	 }

	 public void setEnd_time(String end_time) {
	  this.end_time = end_time;
	 }

	 public void setOrder_type(String order_type) {
	  this.order_type = order_type;
	 }

	 public void setPage(String page) {
	  this.page = page;
	 }

	 public void setTimestamp(String timestamp) {
	  this.timestamp = timestamp;
	 }

	 public void setSign(String sign) {
	  this.sign = sign;
	 }

	@Override
	public String toString() {
		return "MerchantTransactionRecordQueryRequest [institution_number=" + institution_number + ", mch_no=" + mch_no
				+ ", start_time=" + start_time + ", end_time=" + end_time + ", order_type=" + order_type + ", page="
				+ page + ", timestamp=" + timestamp + ", sign=" + sign + "]";
	}

}
