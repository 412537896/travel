package com.weiminw.web.services;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

import javax.servlet.ServletContext;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

@Path("/reservationRequest")
public class ReservationRequestResource {
	@Context
	UriInfo uriInfo;
	@Context
	ServletContext servletContext;
	
	private final static Logger logger = Logger.getLogger(ReservationRequestResource.class);
	@Path("/")
	@POST
	public Response createReservationRequest(@FormParam("lowPrice") double lowPrice,@FormParam("highPrice") double highPrice,@FormParam("checkIn") Date checkIn,@FormParam("checkOut") Date checkOut) {
		ExecutorService s = (ExecutorService) this.servletContext.getAttribute("executors");
		s.submit(new Callable<String>(){

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				logger.debug("----------");
				return "";
			}});
		return Response.created(uriInfo.getRequestUri().resolve(UUID.randomUUID().toString())).build();
		
	}
}
