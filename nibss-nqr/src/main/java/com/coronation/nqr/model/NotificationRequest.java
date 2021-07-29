package com.coronation.nqr.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class NotificationRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String institution_number;
	@JsonProperty
	private String mch_no;
	@JsonProperty
	private String sub_mch_no;
	@JsonProperty
	private String session_id;
	@JsonProperty
	private String amount;
	@JsonProperty
	private String timestamp;
	@JsonProperty
	private String sign;
	
	public String getInstitution_number() {
		return institution_number;
	}
	public void setInstitution_number(String institution_number) {
		this.institution_number = institution_number;
	}
	public String getMch_no() {
		return mch_no;
	}
	public void setMch_no(String mch_no) {
		this.mch_no = mch_no;
	}
	public String getSub_mch_no() {
		return sub_mch_no;
	}
	public void setSub_mch_no(String sub_mch_no) {
		this.sub_mch_no = sub_mch_no;
	}
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
}
