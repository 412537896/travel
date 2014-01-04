package com.weiminw.web.services;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.weiminw.business.managers.HotelManager;
import com.weiminw.business.spatial.HotelSpatial;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.IHotelManager;
import com.weiminw.travel.persistence.impls.MySqlPersistence;
import com.weiminw.travel.persistence.impls.pos.HotelPO;

@Path("/around/hotels/")
public class AroundHotelResource {
	private static final Gson gson = new Gson();
//	private static final MySqlPersistence<IHotel> p = new MySqlPersistence<IHotel>();
	private static final IHotelManager hotelManager = HotelManager.create();
	
	private static final Logger logger = LogManager.getLogger(AroundHotelResource.class);
	@GET
	@Consumes(MediaType.APPLICATION_JSON+";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	public String getHotels(@QueryParam("lnt") double lnt,@QueryParam("lat") double lat,@QueryParam("start") int start){
		List<IHotel> hotels = hotelManager.getHotelsByLntLat(lnt,lat,0);
		return gson.toJson(hotels);
	}
	
	@Path("/a")
	@GET
	@Consumes(MediaType.APPLICATION_JSON+";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	public String getHotels_1(@QueryParam("lnt") double lnt,@QueryParam("lat") double lat,@QueryParam("start") int start){
		List<Long> hotelIds;
		try {
			hotelIds = HotelSpatial.search(lnt, lat, 5);
			Collection<IHotel> hotels = Collections2.transform(hotelIds, new Function<Long,IHotel>(){

				@Override
				public IHotel apply(Long input) {
					// TODO Auto-generated method stub
					return hotelManager.getHotelById(input);
				}
				
				
			});
			return gson.toJson(hotels);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "";
		}
		
		
	}
	
}
