package com.weiminw.travel.interfaces;

import java.util.List;

public interface IHotelManager {
	IHotel getHotelById(long id);
	List<IHotel> getHotels();
//	List<IHotel> getHotelsByLntLat(double lnt, double lat);
	List<IHotelLocation> getHotelsByLntLat(double lnt, double lat,int start);
	boolean updateHotel(IHotel hotel);
}
