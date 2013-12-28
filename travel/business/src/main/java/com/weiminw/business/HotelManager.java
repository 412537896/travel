package com.weiminw.business;

import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.Maps;
import com.weiminw.business.exceptions.IllegalArgumentExceptionEnum;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.IHotelManager;
import com.weiminw.travel.persistence.impls.MySqlPersistence;
import com.weiminw.travel.persistence.impls.pos.HotelPO;

public class HotelManager implements IHotelManager {
	final static MySqlPersistence<IHotel> persistence = MySqlPersistence.create();
	@Override
	public IHotel getHotelById(long id) {
		Preconditions.checkArgument(id>0,IllegalArgumentExceptionEnum.ID_INVALID.getMessage());
		return persistence.getPersistenceObject(HotelPO.class, id);
	}
	
	@Override
	public List<IHotel> getHotels() {
		// TODO Auto-generated method stub
		return null;
	}

	public final static IHotelManager newInstance() {
		// TODO Auto-generated method stub
		return new HotelManager();
	}

	@Override
	public List<IHotel> getHotelsByLntLat(double lnt, double lat) {
		double minLnt = lnt - 0.05;
		double maxLnt = lnt + 0.05;
		double minLat  = lat - 0.05;
		double maxLat = lat + 0.05;
		List<IHotel> hotels = persistence.getPersistenceObjects("HotelPO.findPOI",
				Maps.immutableEntry("minLnt", minLnt),
				Maps.immutableEntry("maxLnt", maxLnt),
				Maps.immutableEntry("minLat", minLat),
				Maps.immutableEntry("maxLat", maxLat)
				);
		return hotels;
		
	}

}
