package com.weiminw.travel.persistence.impls.pos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hotel database table.
 * 
 */
@Entity
@Table(name="hotel")
@NamedQuery(name="HotelSpatialEntity.findAll", query="SELECT h FROM HotelSpatialEntity h")
public class HotelSpatialEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String address;
	private int city;
	private double latitude;
	private double longitude;
	private String name;

	public HotelSpatialEntity() {
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

}