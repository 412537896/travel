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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.weiminw.travel.interfaces.ICity;
import com.weiminw.travel.interfaces.IProvince;
import com.weiminw.travel.persistence.impls.MySqlPersistence;
import com.weiminw.travel.persistence.impls.pos.HotelPO;
@Path("hotels")
public class HotelResource {
	private static final Gson gson;
	static {
		gson = new GsonBuilder()
		.registerTypeAdapter(ICity.class, new TypeAdapter<ICity>(){

			@Override
			public ICity read(JsonReader reader) throws IOException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void write(JsonWriter writer, ICity city) throws IOException {
				// TODO Auto-generated method stub
				if(city == null){
					writer.nullValue();
					return;
				}
				writer.value(city.getCityName());
				
			}
			
		})
		.registerTypeAdapter(IProvince.class, new TypeAdapter<IProvince>(){

			@Override
			public IProvince read(JsonReader reader) throws IOException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void write(JsonWriter writer, IProvince province)
					throws IOException {
				// TODO Auto-generated method stub
				if(province == null) {
					writer.nullValue();
					return;
				}
				writer.value(province.getProvinceName());
				
			}
			
		})
		.create();
	}
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

	@Consumes(MediaType.APPLICATION_JSON+";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	public String getHotel(@PathParam("id") long id) {
		HotelPO hotelPO = p.getPersistenceObject(HotelPO.class, id);
		System.out.println(hotelPO);
        return gson.toJson(hotelPO);
    }
	
	
	@GET
	@Path("/{id}")
	@Consumes("image/png")
	@Produces("image/png")
	public Response getHotel2(@PathParam("id") long id) throws URISyntaxException {
		return Response.temporaryRedirect(new URI("/travel/pictures/10000442_1.png")).build();
    }
}
