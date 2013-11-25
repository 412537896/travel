package com.weiminw.web.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.weiminw.travel.persistence.impls.MySqlPersistence;
import com.weiminw.travel.persistence.impls.pos.HotelPO;
@Path("hotels")
public class HotelResource {
	private static final Gson gson = new Gson();
	MySqlPersistence<HotelPO> p = new MySqlPersistence<HotelPO>();
	@GET
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
    public String getHotels() {
		List<HotelPO> list = p.getPersistenceObjects("HotelPO.findAll");
		System.out.println(list);
        return gson.toJson(list);
    }
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	public String getHotel(@PathParam("id") long id) {
		HotelPO hotelPO = p.getPersistenceObject(HotelPO.class, id);
		System.out.println(hotelPO);
        return gson.toJson(hotelPO);
    }
}
