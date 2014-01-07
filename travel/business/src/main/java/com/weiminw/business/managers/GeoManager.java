package com.weiminw.business.managers;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.weiminw.business.aos.City;
import com.weiminw.business.aos.Province;
import com.weiminw.travel.interfaces.ICity;
import com.weiminw.travel.interfaces.IProvince;
import com.weiminw.travel.persistence.IPersistence;
import com.weiminw.travel.persistence.impls.MySqlPersistence;
import com.weiminw.travel.persistence.impls.pos.GeoEntity;

public class GeoManager {
	IPersistence<GeoEntity> persistence = MySqlPersistence.create();
	
	public IProvince getProvince(int provinceCode){
		Map.Entry<String,Integer> provinceCodeParam = Maps.immutableEntry("provinceCode", provinceCode);
		@SuppressWarnings("unchecked")
		List<GeoEntity> entities = persistence.getPersistenceObjects("GeoEntity.findProvince",provinceCodeParam);
		if(entities.isEmpty()){
			return IProvince.NULL;
		}
		else {
			return Province.builder().setProvinceCode(entities.get(0).getProvinceCode()).setProvinceName(entities.get(0).getProvinceName()).build();
		}
	}
	
	public ICity getCity(int cityCode){
		Map.Entry<String, Integer> cityCodeParam = Maps.immutableEntry("cityCode", cityCode);
		@SuppressWarnings("unchecked")
		List<GeoEntity> entities = persistence.getPersistenceObjects("GeoEntity.findCity",cityCodeParam);
		if(entities.isEmpty()){
			return ICity.NULL;
		}
		else {
			return City.builder().setCityCode(entities.get(0).getCityCode()).setCityName(entities.get(0).getCityName()).build();
		}
	}
}
