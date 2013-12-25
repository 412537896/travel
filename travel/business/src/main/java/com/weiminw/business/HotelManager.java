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
	final static MySqlPersistence<IHotel> persistence = MySqlPersistence.newInstance();
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
		Map<String,Double> params = Maps.newHashMap();
		double minLnt = lnt - 1;
		double maxLnt = lnt + 1;
		double minLat  = lat - 1;
		double maxLat = lat + 1;
		params.put("minLnt", minLnt);
		params.put("maxLnt", maxLnt);
		params.put("minLat", minLat);
		params.put("maxLat", maxLat);
		List<IHotel> hotels = persistence.getPersistenceObjects("HotelPO.findPOI",params);
		return hotels;
		
	}

}
