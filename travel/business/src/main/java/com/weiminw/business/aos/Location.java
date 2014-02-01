package com.weiminw.business.aos;

import com.google.common.base.Objects;
import com.weiminw.travel.interfaces.ILocation;

public class Location implements ILocation {
	private final double longitude;
	private final double latitude;

	private Location(double longitude, double latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public static Location of(double longitude, double latitude){
		return new Location(longitude, latitude);
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
	
	public String toString(){
		return Objects.toStringHelper(this).add("longitude", this.longitude).add("latitude", this.latitude).toString();
	}

}
