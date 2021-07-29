package com.coronation.sevenupApp.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class TransactionAmount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty
	private String amountValue;

	@JsonProperty
    private String currencyCode;

    public void setAmountValue(String amountValue){
        this.amountValue = amountValue;
    }
    public String getAmountValue(){
        return this.amountValue;
    }
    public void setCurrencyCode(String currencyCode){
        this.currencyCode = currencyCode;
    }
    public String getCurrencyCode(){
        return this.currencyCode;
    }
	
}
