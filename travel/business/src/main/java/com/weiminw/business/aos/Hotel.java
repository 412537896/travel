package com.weiminw.business.aos;

import com.google.common.base.Function;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.persistence.impls.pos.HotelPO;
import com.weiminw.travel.utils.LntLatCaculator;

public class Hotel implements IHotel {
	private final long id;
	private final String name;
	private final String address;
	private final double longtitude;
	private final double latitude;
	private final String telephone;
	private final long distance;
	
	
	

	public Hotel(long id, String name, String address, double longtitude,
			double latitude, String telephone, long distance) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.longtitude = longtitude;
		this.latitude = latitude;
		this.telephone = telephone;
		this.distance = distance;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getLongtitude() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getLatitude() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTelephone() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public long getDistance(){
		return this.distance;
	}
	
	public static final Function<HotelPO,IHotel> getHotelTrans(final double currentLnt,final double currentLat){
		return new Function<HotelPO,IHotel>(){

			@Override
			public IHotel apply(HotelPO input) {
				return new Hotel(
						input.getId(),
						input.getName(),
						input.getAddress(),
						input.getLongtitude(),
						input.getLatitude(),
						input.getTelephone(),
						LntLatCaculator.GetDistance(input.getLatitude(), input.getLongtitude(), currentLat, currentLnt)
						);
			}
			
		};
	}
	

}
