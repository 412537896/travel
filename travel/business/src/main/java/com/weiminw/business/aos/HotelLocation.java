package com.weiminw.business.aos;

import com.weiminw.travel.interfaces.IHotelLocation;

public class HotelLocation implements IHotelLocation {
	private final long id;
	private final String name;
	private final double longitude;
	private final double latitude;
	
	
	public HotelLocation(long id, String name, double longitude, double latitude) {
		super();
		this.id = id;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getName() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getLongitude() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getLatitude() {
		// TODO Auto-generated method stub
		return 0;
	}

}