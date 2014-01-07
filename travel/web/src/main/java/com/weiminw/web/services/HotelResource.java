package com.weiminw.web.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.weiminw.business.managers.HotelManager;
import com.weiminw.travel.interfaces.ICity;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.IHotelManager;
import com.weiminw.travel.interfaces.IProvince;
import com.weiminw.travel.persistence.impls.MySqlPersistence;
import com.weiminw.travel.persistence.impls.pos.HotelEntity;
import com.weiminw.web.services.json.CityJsonAdapter;
import com.weiminw.web.services.json.ProvinceJsonAdapter;
@Path("hotels")
public class HotelResource {
	private static final Gson gson = new GsonBuilder()
										.registerTypeAdapter(ICity.class, CityJsonAdapter.newInstance())
										.registerTypeAdapter(IProvince.class, ProvinceJsonAdapter.newInstance())
										.create();
	
	IHotelManager hotelManager = HotelManager.create();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
    public Response getHotels() {
		return Response.status(Status.REQUEST_ENTITY_TOO_LARGE).build();
    }
	@GET
	@Path("/{id}")

	@Consumes(MediaType.APPLICATION_JSON+";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	public String getHotel(@PathParam("id") long id) {
		IHotel hotelPO = hotelManager.getHotelById(id);
		return gson.toJson(hotelPO);
    }
	
	
	@GET
	@Path("/{id}")
	@Consumes("image/*")
	@Produces("image/*")
	public Response getHotel2(@PathParam("id") long id) throws URISyntaxException {
		return Response.temporaryRedirect(new URI("/travel/pictures/10000442_1.png")).build();
    }
}
