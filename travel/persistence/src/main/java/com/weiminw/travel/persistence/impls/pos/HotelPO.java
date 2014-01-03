package com.weiminw.travel.persistence.impls.pos;

import java.io.Serializable;

import javax.persistence.*;

import com.google.common.base.Objects;
import com.weiminw.travel.interfaces.ICity;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.IProvince;
import com.weiminw.travel.interfaces.IUser;

import java.util.Collection;
import java.util.List;


/**
 * The persistent class for the hotel database table.
 * 
 */
public class HotelPO implements Serializable,IHotel {

	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String address;
	private String description;
	private int provinceCode ;
	private int cityCode ;
	private double longtitude ;
	private double latitude;
	private String telephone ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(int provinceCode) {
		this.provinceCode = provinceCode;
	}
	public int getCityCode() {
		return cityCode;
	}
	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}
	public double getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Transient
	@Override
	public long getDistance() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String toString() {
		return "HotelPO [id=" + id + ", name=" + name + ", address=" + address
				+ ", description=" + description + ", provinceCode="
				+ provinceCode + ", cityCode=" + cityCode + ", longtitude="
				+ longtitude + ", latitude=" + latitude + ", telephone="
				+ telephone + "]";
	}
	
	

	
}