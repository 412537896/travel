package com.weiminw.web.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Stopwatch;
import com.weiminw.business.aos.HotelReservationRequest;
import com.weiminw.travel.dao.impls.AccountManager;
import com.weiminw.travel.dao.impls.HotelManager;
import com.weiminw.travel.interfaces.daos.IHotelLocation;
import com.weiminw.travel.interfaces.daos.IReservationRequest;
import com.weiminw.travel.interfaces.daos.IUser;

@Path("/hotel/biding")
public class HotelBidingResource {
	@Context
	UriInfo uriInfo;
	HotelManager hotelManager = HotelManager.create();
	AccountManager userManager = AccountManager.create();
	private final static Logger logger = LogManager.getLogger(HotelBidingResource.class);
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
		List<IHotelLocation> hotels = this.hotelManager.getHotelLocation(lnt, lat, 5, 0, 50);
		logger.debug("�ҵ����� "+hotels.size()+" �ҾƵ�");
		stopwatch.start();		
		for(IHotelLocation hotel:hotels){
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
