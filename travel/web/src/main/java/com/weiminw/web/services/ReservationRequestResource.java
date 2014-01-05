package com.weiminw.web.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContext;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.weiminw.business.aos.HotelReservationRequest;
import com.weiminw.business.aos.Seller;
import com.weiminw.business.managers.HotelManager;
import com.weiminw.business.managers.UserManager;
import com.weiminw.business.workers.NotifyMessageSendWorker;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.IHotelManager;
import com.weiminw.travel.interfaces.IReservationRequest;
import com.weiminw.travel.interfaces.IUser;
import com.weiminw.travel.interfaces.IUserManager;

@Path("/reservation/request")
public class ReservationRequestResource {
	@Context
	UriInfo uriInfo;
	IHotelManager hotelManager = HotelManager.create();
	IUserManager userManager = UserManager.create();
	private final static Logger logger = LogManager.getLogger(ReservationRequestResource.class);
	private final Stopwatch stopwatch = Stopwatch.createUnstarted();
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
		List<IHotel> hotels = this.hotelManager.getHotelsByLntLat(lnt, lat, 0);
		logger.debug("�ҵ����� "+hotels.size()+" �ҾƵ�");
		stopwatch.start();		
		for(IHotel hotel:hotels){
			List<IUser> users = this.userManager.getSellerByHid(hotel.getId());
			for(IUser user:users){
				IReservationRequest message = HotelReservationRequest.create(user, user);
				message.send();
			}
		}
		logger.debug(stopwatch.elapsed(TimeUnit.MILLISECONDS));
		return Response.created(uriInfo.getRequestUri().resolve(UUID.randomUUID().toString())).build();
		
	}
}
