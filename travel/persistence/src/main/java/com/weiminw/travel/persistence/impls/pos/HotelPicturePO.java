package com.weiminw.travel.persistence.impls.pos;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class HotelPicturePO implements Serializable {

	 
	private long id; 
	private String url;
	private static final long serialVersionUID = 1L;	
	public HotelPicturePO() {
		super();
	} 
	public long getId() {
 		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getUrl() {
 		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
   
}
