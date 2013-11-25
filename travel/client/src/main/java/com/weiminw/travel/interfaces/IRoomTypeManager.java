package com.weiminw.travel.interfaces;

import java.util.List;

public interface IRoomTypeManager {
	IRoomType getRoomTypeById(long id);
	List<IRoomType> getRoomTypeByHotelId(long hid);
}
