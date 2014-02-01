package com.weiminw.web.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.weiminw.business.managers.RoomTypeManager;
import com.weiminw.travel.interfaces.IRoomType;
import com.weiminw.travel.interfaces.managers.IRoomTypeManager;
import com.weiminw.travel.persistence.IPersistence;
import com.weiminw.travel.persistence.impls.MySqlPersistence;
import com.weiminw.travel.persistence.impls.pos.RoomTypePO;
@Path("/hotels/{hid}/roomtypes")
public class RoomTypeResource {
	private static final Gson gson = new Gson();
	IRoomTypeManager manager = RoomTypeManager.newInstance();
	@GET
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
    public String getHotelRoomTypes(@PathParam("hid") long hid) {
		List<IRoomType> list = manager.getRoomTypeByHotelId(hid);
		return gson.toJson(list);
		
	}
}
