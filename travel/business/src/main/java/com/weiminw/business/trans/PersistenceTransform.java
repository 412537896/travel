package com.weiminw.business.trans;

import com.google.common.base.Function;
import com.weiminw.business.aos.Hotel;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.persistence.impls.pos.HotelPO;

public final class PersistenceTransform {
	public static Function<HotelPO,IHotel> getHotelTrans(){
		return new Function<HotelPO,IHotel>(){
			@Override
			public IHotel apply(HotelPO input) {
				return Hotel.builder(input.getId())
						.name(input.getName())
						.address(input.getAddress())
						.description(input.getDescription())
						.longitude(input.getLongitude())
						.latitude(input.getLatitude())
						.telephone(input.getTelephone())
						.city(input.getCity())
						.province(input.getProvince()).build();
			}
			
		};
	}
}
