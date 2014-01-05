package com.weiminw.travel.persistence.impls.pos;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the hotel database table.
 * 
 */
@Entity
@Table(name="hotel")
@NamedQueries(value = {
		@NamedQuery(name="HotelEntity.findAll", query="SELECT h FROM HotelEntity h")
		
		
})

public class HotelEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String address;
	private int city;
	private String description;
	private double latitude;
	private double longitude;
	private String name;
	private String pictures;
	private int province;
	private String telephone;

	public HotelEntity() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public int getCity() {
		return this.city;
	}

	public void setCity(int city) {
		this.city = city;
	}


	@Lob
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Lob
	public String getPictures() {
		return this.pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}


	public int getProvince() {
		return this.province;
	}

	public void setProvince(int province) {
		this.province = province;
	}


	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}