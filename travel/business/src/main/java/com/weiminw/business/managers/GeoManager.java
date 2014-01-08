package com.weiminw.business.managers;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import com.weiminw.business.aos.City;
import com.weiminw.business.aos.Province;
import com.weiminw.travel.interfaces.ICity;
import com.weiminw.travel.interfaces.IProvince;
import com.weiminw.travel.persistence.IPersistence;
import com.weiminw.travel.persistence.impls.MySqlPersistence;
import com.weiminw.travel.persistence.impls.pos.GeoEntity;

public class GeoManager {
	private static final  IPersistence<GeoEntity> persistence = MySqlPersistence.create();
	private static final  LoadingCache<Integer,IProvince> provinceCache = CacheBuilder.newBuilder()
		       .maximumSize(1000)
		       .build(
		           new CacheLoader<Integer, IProvince>() {

					@Override
					public IProvince load(Integer key) {
						// TODO Auto-generated method stub
						Map.Entry<String,Integer> provinceCodeParam = Maps.immutableEntry("provinceCode", key);
						@SuppressWarnings("unchecked")
						List<GeoEntity> entities = persistence.getPersistenceObjects("GeoEntity.findProvince",provinceCodeParam);
						if(entities.isEmpty()){
							return IProvince.NULL;
						}
						else {
							return Province.builder().setProvinceCode(entities.get(0).getProvinceCode()).setProvinceName(entities.get(0).getProvinceName()).build();
						}
					}
		           });
	private static final LoadingCache<Integer,ICity> cityCache = CacheBuilder.newBuilder()
		       .maximumSize(1000)
		       .build(
		           new CacheLoader<Integer, ICity>() {

					@Override
					public ICity load(Integer key) {
						// TODO Auto-generated method stub
						Map.Entry<String, Integer> cityCodeParam = Maps.immutableEntry("cityCode", key);
						@SuppressWarnings("unchecked")
						List<GeoEntity> entities = persistence.getPersistenceObjects("GeoEntity.findCity",cityCodeParam);
						if(entities.isEmpty()){
							return ICity.NULL;
						}
						else {
							return City.builder().setCityCode(entities.get(0).getCityCode()).setCityName(entities.get(0).getCityName()).build();
						}
					}
		           });
	public IProvince getProvince(int provinceCode){
		try {
			return provinceCache.get(provinceCode);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return IProvince.NULL;
		}
	}
	
	public ICity getCity(int cityCode){
		try {
			return cityCache.get(cityCode);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ICity.NULL;
		}
	}
}
