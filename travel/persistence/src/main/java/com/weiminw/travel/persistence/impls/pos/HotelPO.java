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
public class HotelPO implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String address;
	private String description;
	private int provinceCode ;
	private int cityCode ;
	private double longitude ;
	private double latitude;
	private String telephone ;
	
	public HotelPO() {
		
	}
	public HotelPO(IHotel hotel){
		this.id = hotel.getId();
		this.name = hotel.getName();
		this.address = hotel.getAddress();
		this.description = hotel.getDescription();
		this.provinceCode = hotel.getProvince();
		this.cityCode = hotel.getCity();
		this.longitude = hotel.getLongitude();
		this.latitude = hotel.getLatitude();
	}
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
	public int getProvince() {
		return provinceCode;
	}
	public void setProvince(int provinceCode) {
		this.provinceCode = provinceCode;
	}
	public int getCity() {
		return cityCode;
	}
	public void setCity(int cityCode) {
		this.cityCode = cityCode;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + cityCode;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + provinceCode;
		result = prime * result
				+ ((telephone == null) ? 0 : telephone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelPO other = (HotelPO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cityCode != other.cityCode)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(latitude) != Double
				.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double
				.doubleToLongBits(other.longitude))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (provinceCode != other.provinceCode)
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}
	
	
	
	
	
	

	
}