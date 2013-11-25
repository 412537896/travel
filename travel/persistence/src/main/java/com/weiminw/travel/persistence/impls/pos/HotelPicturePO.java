package com.weiminw.travel.persistence.impls.pos;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="hotel_picture")
public final class HotelPicturePO implements Serializable {

	 
	private long id; 
	private long hotelId; 
	private String url;
	private static final long serialVersionUID = 1L;	
	public HotelPicturePO() {
		super();
	} 
	@Id   
	public long getId() {
 		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Column(name="hotel_id")   
	public long getHotelId() {
 		return this.hotelId;
	}

	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}
	@Column(name="url")     
	public String getUrl() {
 		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
   
}
