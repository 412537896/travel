package com.weiminw.travel.persistence.impls.pos;

import java.lang.String;

import javax.persistence.*;

import com.google.common.base.Objects;
import com.weiminw.travel.interfaces.IHotel;

/**
 * Entity implementation class for Entity: HotelPO
 *
 */
@Entity(name="hotel")
@NamedQuery(name="HotelPO.findAll",query="select H from hotel H ")
public final class HotelPO implements IHotel {
	private long id;
	private String name;
	private String address;
	private String description;
	private int province ;
	private int city ;
	private double longtitude ;
	private double latitude;
	private String telephone ;
	private static final long serialVersionUID = 1L;
	

	public HotelPO() {
		super();
	}   
	@Id    
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Column(name="name")  
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	@Column(name="address")  
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="description")  
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="province")  
	public int getProvince() {
		return province;
	}
	public void setProvince(int province) {
		this.province = province;
	}
	@Column(name="city")  
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	@Column(name="longtitude")  
	public double getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
	@Column(name="latitude")  
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	@Column(name="telephone")  
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String toString() {
		return Objects.toStringHelper(this)
				.add("id", id)
				.add("name", name)
				.add("address", address)
				.add("description", description)
				.add("province", province)
				.add("longtitude", longtitude)
				.add("latitude", latitude)
				.add("telephone", telephone)
				.toString();

	};
   
}
