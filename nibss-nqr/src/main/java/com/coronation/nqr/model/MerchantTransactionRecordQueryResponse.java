package com.coronation.nqr.model;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class MerchantTransactionRecordQueryResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String ReturnCode;
	@JsonProperty
	 private String Page;
	@JsonProperty
	 private String TotalRows;
	@JsonProperty
	 private String TotalPages;
	@JsonProperty
	 ArrayList <Liist> List = new ArrayList <> ();


	 // Getter Methods 

	 public String getReturnCode() {
	  return ReturnCode;
	 }

	 public String getPage() {
	  return Page;
	 }

	 public String getTotalRows() {
	  return TotalRows;
	 }

	 public String getTotalPages() {
	  return TotalPages;
	 }

	 public ArrayList<Liist> getList() {
			return List;
		}
	 
	 // Setter Methods 

	 public void setReturnCode(String ReturnCode) {
	  this.ReturnCode = ReturnCode;
	 }

	 public void setPage(String Page) {
	  this.Page = Page;
	 }

	 public void setTotalRows(String TotalRows) {
	  this.TotalRows = TotalRows;
	 }

	 public void setTotalPages(String TotalPages) {
	  this.TotalPages = TotalPages;
	 }

	public void setList(ArrayList<Liist> list) {
		List = list;
	}
	
}
