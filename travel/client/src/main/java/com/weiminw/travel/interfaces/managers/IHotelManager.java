package com.weiminw.travel.interfaces.managers;

import java.util.List;

import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.IHotelLocation;

public interface IHotelManager {
	IHotel getHotelById(long id);
	List<IHotel> getHotels();
	List<IHotelLocation> getHotelsByLntLat(double lnt, double lat,int start);
	boolean updateHotel(IHotel hotel);
}
