package com.weiminw.business.trans;

import com.google.common.base.Function;
import com.weiminw.business.aos.Hotel;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.persistence.impls.pos.HotelEntity;

public final class HotelTransform {
	public static Function<HotelEntity,IHotel> HotelEntity2Hotel(){
		return new Function<HotelEntity,IHotel>(){
			@Override
			public IHotel apply(HotelEntity input) {
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
	public static Function<IHotel,HotelEntity> Hotel2HotelEntity(){
		return new Function<IHotel,HotelEntity>(){

			@Override
			public HotelEntity apply(IHotel input) {
				HotelEntity entity = new HotelEntity();
				entity.setCity(input.getCity());
				entity.setAddress(input.getAddress());
				entity.setDescription(input.getDescription());
				entity.setId(input.getId());
				entity.setLatitude(input.getLatitude());
				entity.setLongitude(input.getLongitude());
				entity.setName(input.getName());
				entity.setProvince(input.getProvince());
				entity.setTelephone(input.getTelephone());
				return entity;
			}
		};
	}
}
