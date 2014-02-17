package com.weiminw.business.aos;

import java.io.Serializable;

import com.weiminw.travel.interfaces.daos.IHotel;


public class Hotel implements IHotel,Serializable {

	private final long id;
	private final String name;
	private final String description;
	private final int province;
	private final int city;
	private final String address;
	private final double latitude;
	private final double longitude;
	private final String telephone;
	/**
	 * 
	 */
	private static final long serialVersionUID = -5713403096635565244L;
	
	
	

	private Hotel(long id, String name, String description, int province,
			int city, String address, double latitude, double longitude,
			String telephone) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.province = province;
		this.city = city;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.telephone = telephone;
	}
	
	public static IHotel of(long id, String name, String description, int province,
			int city, String address, double latitude, double longitude,
			String telephone){
		return new Hotel(id, name, description, province, city, address, latitude, longitude, telephone);
	}
	

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public IHotel setId(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getAddress() {
		return this.address;
	}

	@Override
	public IHotel setAddress(String address) {
		return Hotel.of(id, address, address, province, city, address, latitude, longitude, address);
	}

	@Override
	public int getCity() {
		return this.city;
	}

	@Override
	public IHotel setCity(int city) {
		return Hotel.of(city, name, description, city, city, address, city, city, telephone);
	}

	@Override
	public String getCityName() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

	@Override
	public IHotel setDescription(String description) {
		return Hotel.of(id, description, description, province, city, description, latitude, longitude, description);
	}

	@Override
	public double getLatitude() {
		return this.latitude;
	}

	@Override
	public IHotel setLatitude(double latitude) {
		// TODO Auto-generated method stub
		return Hotel.of(id, name, description, province, city, address, latitude, latitude, telephone);
	}

	@Override
	public double getLongitude() {
		// TODO Auto-generated method stub
		return this.longitude;
	}

	@Override
	public IHotel setLongitude(double longitude) {
		// TODO Auto-generated method stub
		return Hotel.of(id, name, description, province, city, address, longitude, longitude, telephone);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public IHotel setName(String name) {
		// TODO Auto-generated method stub
		return Hotel.of(id, name, name, province, city, name, latitude, longitude, name);
	}


	@Override
	public int getProvince() {
		// TODO Auto-generated method stub
		return this.province;
	}

	@Override
	public IHotel setProvince(int province) {
		// TODO Auto-generated method stub
		return Hotel.of(province, name, description, province, province, address, province, province, telephone);
	}

	@Override
	public String getProvinceName() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getTelephone() {
		// TODO Auto-generated method stub
		return this.telephone;
	}

	@Override
	public IHotel setTelephone(String telephone) {
		// TODO Auto-generated method stub
		return Hotel.of(id, telephone, telephone, province, city, telephone, latitude, longitude, telephone);
	}
	
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", description="
				+ description + ", province=" + province + ", city=" + city
				+ ", address=" + address + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", telephone=" + telephone + "]";
	}

	public static void main(String[] args) {
		IHotel hotel = Hotel.of(1, "1", "1", 1, 1, "1", 1, 1, "1");
		IHotel hotel2 = hotel.setAddress("2");
		System.out.println(hotel);
		System.out.println(hotel2);
	}



	
	
	

}
