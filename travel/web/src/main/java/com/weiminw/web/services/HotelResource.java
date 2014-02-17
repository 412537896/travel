package com.weiminw.web.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
import com.weiminw.travel.dao.impls.HotelManager;
import com.weiminw.travel.interfaces.daos.IHotel;
import com.weiminw.travel.interfaces.managers.IHotelManager;
@Path("hotels")
public class HotelResource {
	private static final Gson gson = new GsonBuilder()
										.create();
	
	HotelManager hotelDAO = HotelManager.create();
	
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
		IHotel hotel = hotelDAO.getHotelById(id);
		return gson.toJson(hotel);
    }
	
	
	@GET
	@Path("/{id}")
	@Consumes("image/*")
	@Produces("image/*")
	public Response getHotel2(@PathParam("id") long id) throws URISyntaxException {
		return Response.temporaryRedirect(new URI("/travel/pictures/10000442_1.png")).build();
    }
}
