package com.weiminw.travel.interfaces;

import java.util.List;

public interface IHotelManager {
	IHotel getHotelById(long id);
	List<IHotel> getHotels();
}
