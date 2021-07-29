package com.coronation.sevenupApp.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class Rec implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	AccId acctId;
	@JsonProperty
	String creditDebitFlg;
	@JsonProperty
	int serialNum;
	@JsonProperty
	TransactionAmount trnAmt;
	@JsonProperty
	String trnParticulars;
	
	public String getTrnParticulars() {
		return trnParticulars;
	}
	public void setTrnParticulars(String trnParticulars) {
		this.trnParticulars = trnParticulars;
	}
	
	public AccId getAcctId() {
		return acctId;
	}
	public void setAcctId(AccId acctId) {
		this.acctId = acctId;
	}
	public String getCreditDebitFlg() {
		return creditDebitFlg;
	}
	public void setCreditDebitFlg(String creditDebitFlg) {
		this.creditDebitFlg = creditDebitFlg;
	}
	public int getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}
	public TransactionAmount getTrnAmt() {
		return trnAmt;
	}
	public void setTrnAmt(TransactionAmount trnAmt) {
		this.trnAmt = trnAmt;
	}
	
}
