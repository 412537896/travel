package com.weiminw.web.services;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.weiminw.business.aos.Seller;
import com.weiminw.travel.dao.impls.AccountManager;
import com.weiminw.travel.interfaces.daos.IUser;
import com.weiminw.travel.interfaces.managers.IUserManager;

@Path("/sellers")
public class SellerResource {
	AccountManager manager = AccountManager.create();
	@Context
	UriInfo uriInfo;
	@POST
	public Response createUser(@FormParam(value = "name") String name,
			@FormParam(value="cellPhone") String cellPhone,
			@FormParam(value="cloudPushCk") String cloudPushCk,
			@FormParam(value="cloudPushUk") String cloudPushUk,
			@FormParam(value="cloudPushTag") String cloudPushTag,
			@FormParam(value="fixTelephone") String fixTelephone){
//		IUser user = Seller.builder()
//				.setName(name)
//				.setCellPhone(cellPhone)
//				.setCloudPushCk(cloudPushCk)
//				.setCloudPushTag(cloudPushTag)
//				.setCloudPushUk(cloudPushUk)
//				.setFixTelephone(fixTelephone)
//				.setName(name).build();
//		user = manager.addSeller(user);
//		if(user!=null){
//			return Response.created(uriInfo.getRequestUri().resolve(String.valueOf(user.getId()))).build();
//		}
//		else {
			return Response.serverError().build();
//		}
	}
}
