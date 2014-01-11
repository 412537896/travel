package com.weiminw.business.trans;

import com.google.common.base.Function;
import com.weiminw.business.aos.Address;
import com.weiminw.business.aos.Hotel;
import com.weiminw.business.aos.HotelLocation;
import com.weiminw.business.aos.Location;
import com.weiminw.business.managers.GeoManager;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.IHotelLocation;
import com.weiminw.travel.persistence.impls.pos.HotelEntity;

public final class HotelTransform {
	private static final GeoManager manager = new GeoManager();
	private static final Function<HotelEntity,IHotel>  HotelEntity2Hotel = new Function<HotelEntity,IHotel>(){
		@Override
		public IHotel apply(HotelEntity input) {
			String province = manager.getProvince(input.getCity()).getProvinceName();
			String city = manager.getCity(input.getCity()).getCityName();
			return Hotel.builder(input.getId())
					.name(input.getName())
					.description(input.getDescription())
					.telephone(input.getTelephone())
					.address(Address.of(input.getProvince(),province, input.getCity(),city, input.getAddress()))
					.location(Location.of(input.getLongitude(),input.getLatitude()))
					.build();
		}
		
	};
	public static Function<HotelEntity,IHotel> HotelEntity2Hotel(){
		return HotelEntity2Hotel;
	}
	private static final Function<IHotel,HotelEntity> Hotel2HotelEntity = new Function<IHotel,HotelEntity>(){

		@Override
		public HotelEntity apply(IHotel input) {
			HotelEntity entity = new HotelEntity();
			entity.setCity(input.getAddress().getCityCode());
			entity.setAddress(input.getAddress().getDetail());
			entity.setDescription(input.getDescription());
			entity.setId(input.getId());
			entity.setLatitude(input.getLocation().getLatitude());
			entity.setLongitude(input.getLocation().getLongitude());
			entity.setName(input.getName());
			entity.setProvince(input.getAddress().getProvinceCode());
			entity.setTelephone(input.getTelephone());
			return entity;
		}
	};
	public static Function<IHotel,HotelEntity> Hotel2HotelEntity(){
		return Hotel2HotelEntity;
	}
	
	private static final Function<IHotel,IHotelLocation> Hotel2HotelLocation = new Function<IHotel,IHotelLocation> (){

		@Override
		public IHotelLocation apply(IHotel input) {
			HotelLocation hotelLocation = new HotelLocation(input.getId(),input.getName(),input.getLocation().getLongitude(),input.getLocation().getLatitude());
			return hotelLocation;
		}
		
	};
	public static Function<IHotel,IHotelLocation> Hotel2HotelLocation(){
		return Hotel2HotelLocation;
	}
	
	
}
