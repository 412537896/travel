package com.weiminw.web.services;

import java.util.Date;
import java.util.UUID;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/reservationRequest")
public class ReservationRequestResource {
	@Context
	UriInfo uriInfo;
	@Path("/")
	@POST
	public Response createReservationRequest(@FormParam("lowPrice") double lowPrice,@FormParam("lowPrice") double highPrice,@FormParam("lowPrice") Date checkIn,@FormParam("lowPrice") Date checkOut) {
		return Response.created(uriInfo.getRequestUri().resolve(UUID.randomUUID().toString())).build();
//		return Response.accepted().contentLocation().build();
		
	}
}
