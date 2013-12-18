package com.weiminw.travel.persistence.impls.pos;

import java.lang.String;

import javax.persistence.*;

import com.google.common.base.Objects;
import com.weiminw.travel.interfaces.ICity;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.IProvince;

/**
 * Entity implementation class for Entity: HotelPO
 *
 */
@Entity
@Table(name="hotel")
@NamedQueries(value = {
		@NamedQuery(name="HotelPO.findAll",query="select H from HotelPO H "),
		@NamedQuery(name="HotelPO.findPOI",query="select H from HotelPO H where H.longtitude between :minLnt and :maxLnt and H.latitude between :minLat and :maxLat "),
})
public final class HotelPO implements IHotel {
	private long id;
	private String name;
	private String address;
	private String description;
	private int provinceCode ;
	private int cityCode ;
	private double longtitude ;
	private double latitude;
	private String telephone ;
	private ICity city;
	private IProvince province;
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
	public int getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(int provinceCode) {
		this.provinceCode = provinceCode;
	}
	@Column(name="city")  
	public int getCityCode() {
		return cityCode;
	}
	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
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
				.add("province", provinceCode)
				.add("longtitude", longtitude)
				.add("latitude", latitude)
				.add("telephone", telephone)
				.toString();

	}
	@Transient
	@Override
	public IProvince getProvince() {
		// TODO Auto-generated method stub
		return this.province;
	}
	@Transient
	@Override
	public ICity getCity() {
		// TODO Auto-generated method stub
		return this.city;
	};
   
}
