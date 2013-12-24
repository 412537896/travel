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
import com.weiminw.business.MessageSender;
import com.weiminw.business.aos.Seller;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.IHotelManager;
import com.weiminw.travel.interfaces.IReservationRequest;
import com.weiminw.travel.interfaces.ISeller;

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
		List<ISeller> sellers = Lists.newArrayList();
		sellers.add(new Seller());
		String uuid = UUID.randomUUID().toString();
		IReservationRequest request = null;
		for(ISeller seller:sellers){
			logger.debug("-------------");
			MessageSender.sendMessage(request,seller);//�첽���ͣ�
		}
		
		return Response.created(uriInfo.getRequestUri().resolve(UUID.randomUUID().toString())).build();
		
	}
}
