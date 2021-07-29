package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class GenerateDynamicQrCodeRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String channel;
	@JsonProperty
	 private String institution_number;
	@JsonProperty
	 private String mch_no;
	@JsonProperty
	 private String sub_mch_no;
	@JsonProperty
	 private String code_type;
	@JsonProperty
	 private String amount;
	@JsonProperty
	 private String order_no;
	@JsonProperty
	 private String order_type;
	@JsonProperty
	 private String timestamp;
	@JsonProperty
	 private String sign;


	 // Getter Methods 

	 public String getChannel() {
	  return channel;
	 }

	 public String getInstitution_number() {
	  return institution_number;
	 }

	 public String getMch_no() {
	  return mch_no;
	 }

	 public String getSub_mch_no() {
	  return sub_mch_no;
	 }

	 public String getCode_type() {
	  return code_type;
	 }

	 public String getAmount() {
	  return amount;
	 }

	 public String getOrder_no() {
	  return order_no;
	 }

	 public String getOrder_type() {
	  return order_type;
	 }

	 public String getTimestamp() {
	  return timestamp;
	 }

	 public String getSign() {
	  return sign;
	 }

	 // Setter Methods 

	 public void setChannel(String channel) {
	  this.channel = channel;
	 }

	 public void setInstitution_number(String institution_number) {
	  this.institution_number = institution_number;
	 }

	 public void setMch_no(String mch_no) {
	  this.mch_no = mch_no;
	 }

	 public void setSub_mch_no(String sub_mch_no) {
	  this.sub_mch_no = sub_mch_no;
	 }

	 public void setCode_type(String code_type) {
	  this.code_type = code_type;
	 }

	 public void setAmount(String amount) {
	  this.amount = amount;
	 }

	 public void setOrder_no(String order_no) {
	  this.order_no = order_no;
	 }

	 public void setOrder_type(String order_type) {
	  this.order_type = order_type;
	 }

	 public void setTimestamp(String timestamp) {
	  this.timestamp = timestamp;
	 }

	 public void setSign(String sign) {
	  this.sign = sign;
	 }

	@Override
	public String toString() {
		return "GenerateDynamicQrCodeRequest [channel=" + channel + ", institution_number=" + institution_number
				+ ", mch_no=" + mch_no + ", sub_mch_no=" + sub_mch_no + ", code_type=" + code_type + ", amount="
				+ amount + ", order_no=" + order_no + ", order_type=" + order_type + ", timestamp=" + timestamp
				+ ", sign=" + sign + "]";
	}

}
