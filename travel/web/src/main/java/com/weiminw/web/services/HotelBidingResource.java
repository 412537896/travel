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
			@FormParam("lowPrice") double lowPrice,/*最低价格*/
			@FormParam("highPrice") double highPrice,/*最高价格*/
			@FormParam("checkIn") Date checkIn,/*入住时间*/
			@FormParam("checkOut") Date checkOut,/*离店时间*/
			@FormParam("lnt") double lnt,/*用户指定经度*/
			@FormParam("lat") double lat /*用户指定维度 */) {
		String uuid = UUID.randomUUID().toString();
		List<IHotelLocation> hotels = this.hotelManager.getHotelLocation(lnt, lat, 5, 0, 50);
		logger.debug("找到附近 "+hotels.size()+" 家酒店");
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
