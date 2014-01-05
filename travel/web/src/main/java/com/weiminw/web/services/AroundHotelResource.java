package com.weiminw.web.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.weiminw.business.managers.HotelManager;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.IHotelManager;

@Path("/around/hotels/")
public class AroundHotelResource {
	private static final Gson gson = new Gson();
	private static final IHotelManager hotelManager = HotelManager.create();
	private static final Logger logger = LogManager.getLogger(AroundHotelResource.class);
	@Context
	UriInfo uriInfo;
	@GET
	@Consumes(MediaType.APPLICATION_JSON+";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	public String getHotels(@QueryParam("lnt") double lnt,@QueryParam("lat") double lat,@QueryParam("start") int start){
		logger.error(uriInfo.getPath());
		List<IHotel> hotels = hotelManager.getHotelsByLntLat(lnt,lat,0);
		return gson.toJson(hotels);
	}
}
