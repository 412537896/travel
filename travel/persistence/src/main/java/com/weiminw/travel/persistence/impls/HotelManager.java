package com.weiminw.travel.persistence.impls;

import java.util.List;

import com.google.common.cache.CacheLoader;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.IHotelManager;
import com.weiminw.travel.persistence.impls.pos.HotelPO;

public class HotelManager implements IHotelManager {
	final static MySqlPersistence<HotelPO> persistence = new MySqlPersistence<HotelPO>();
	@Override
	public IHotel getHotelById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IHotel> getHotels() {
		// TODO Auto-generated method stub
		return null;
	}

}
