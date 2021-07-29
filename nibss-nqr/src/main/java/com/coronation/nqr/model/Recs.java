package com.coronation.nqr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class Recs implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty
	List<Rec> recs = new ArrayList<>();
	
	@JsonProperty
	String reqUuid;

	public List<Rec> getRecs() {
		return recs;
	}

	public void setRecs(List<Rec> recs) {
		this.recs = recs;
	}
	
	public void addRec(Rec rec) {
		recs.add(rec);
	}

	public String getReqUuid() {
		return reqUuid;
	}

	public void setReqUuid(String reqUuid) {
		this.reqUuid = reqUuid;
	}
	
}
