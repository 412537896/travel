package com.weiminw.web.services;

import java.util.Date;
import java.util.List;
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

import com.google.common.collect.Lists;
import com.weiminw.business.HotelManager;
import com.weiminw.business.MessageSendWorker;
import com.weiminw.business.ReservationMessageFactory;
import com.weiminw.business.aos.User;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.IHotelManager;
import com.weiminw.travel.interfaces.IReservationRequestMessage;
import com.weiminw.travel.interfaces.ISeller;
import com.weiminw.travel.interfaces.IUser;

@Path("/reservationRequest")
public class ReservationRequestResource {
	@Context
	UriInfo uriInfo;
	IHotelManager hotelManager = HotelManager.newInstance();
	private final static Logger logger = Logger.getLogger(ReservationRequestResource.class);
	@Path("/")
	@POST
	public Response createReservationRequest(
			@FormParam("lowPrice") double lowPrice,/*��ͼ۸�*/
			@FormParam("highPrice") double highPrice,/*��߼۸�*/
			@FormParam("checkIn") Date checkIn,/*��סʱ��*/
			@FormParam("checkOut") Date checkOut,/*���ʱ��*/
			@FormParam("lnt") double lnt,/*�û�ָ������*/
			@FormParam("lat") double lat /*�û�ָ��ά�� */) {
		String uuid = UUID.randomUUID().toString();
		IReservationRequestMessage request = null;
		IUser from = new User(),to = new User();
		IReservationRequestMessage message = ReservationMessageFactory.createRequestMessage(from, to);
		message.send();
		
		return Response.created(uriInfo.getRequestUri().resolve(UUID.randomUUID().toString())).build();
		
	}
}
