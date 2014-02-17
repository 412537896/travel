package com.weiminw.travel.dao.impls.pos;

import java.io.Serializable;

import javax.persistence.*;

import com.weiminw.travel.interfaces.daos.IHotel;


/**
 * The persistent class for the hotel database table.
 * 
 */
@Entity
@Table(name="hotel")
@NamedQuery(name="HotelEntity.findAll", query="SELECT h FROM HotelEntity h")
public class HotelEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	
	public static HotelEntity of(IHotel hotel){
		return new HotelEntity(
				hotel.getId(),
				hotel.getAddress(),
				hotel.getCity(),
				hotel.getDescription(),
				hotel.getLatitude(),
				hotel.getLongitude(),
				hotel.getName(),
				null,
				hotel.getProvince(),
				hotel.getTelephone()
				);
	}

	private HotelEntity(long id, String address, int city, String description,
			double latitude, double longitude, String name, String pictures,
			int province, String telephone) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		this.pictures = pictures;
		this.province = province;
		this.telephone = telephone;
	}
	
	public HotelEntity(){
		
	}
	

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