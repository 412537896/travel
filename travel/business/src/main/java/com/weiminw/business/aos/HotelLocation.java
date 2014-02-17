package com.weiminw.business.aos;

import com.weiminw.travel.interfaces.daos.IHotelLocation;

public class HotelLocation implements IHotelLocation {
	private final long id;
	private final String name;
	private final double longitude;
	private final double latitude;
	
	
	private HotelLocation(long id, String name, double longitude, double latitude) {
		super();
		this.id = id;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public static IHotelLocation of(long id, String name, double longitude, double latitude){
		return new HotelLocation(id,name,longitude,latitude);
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public double getLongitude() {
		// TODO Auto-generated method stub
		return this.longitude;
	}

	@Override
	public double getLatitude() {
		// TODO Auto-generated method stub
		return this.latitude;
	}

	@Override
	public IHotelLocation setId(long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public IHotelLocation setName(String name) {
		return HotelLocation.of(id, name, longitude, latitude);
	}

	@Override
	public IHotelLocation setLongitude(double longitude) {
		return HotelLocation.of(id, name, longitude, latitude);
	}

	@Override
	public IHotelLocation setLatitude(double latitude) {
		return HotelLocation.of(id, name, longitude, latitude);
	}

}
