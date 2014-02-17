package com.weiminw.web.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.weiminw.business.aos.Seller;
import com.weiminw.business.aos.User;
import com.weiminw.travel.dao.impls.AccountManager;
import com.weiminw.travel.interfaces.daos.IUser;
import com.weiminw.travel.interfaces.managers.IUserManager;
@Path("/users")
public class UserResource {
	private static final AccountManager manager = AccountManager.create();
	private static final Gson gson = new GsonBuilder().create();
	@Context
	UriInfo uriInfo;
	@POST
	@Consumes("application/x-www-form-urlencoded") 
	public Response createUser(@FormParam(value = "name") String name,
			@FormParam(value="cellPhone") String cellPhone,
			@FormParam(value="cloudPushCk") String cloudPushCk,
			@FormParam(value="cloudPushUk") String cloudPushUk,
			@FormParam(value="cloudPushTag") String cloudPushTag,
			@FormParam(value="fixTelephone") String fixTelephone,
			@FormParam(value="password") String password,
			@FormParam(value="nick") String nick){
		IUser user = User.of(-1, name, cellPhone, cloudPushCk, cloudPushUk, cloudPushTag, password, nick);
		user = manager.addUser(user);
		if(user!=null){
			return Response.created(uriInfo.getRequestUri().resolve(String.valueOf(user.getId()))).build();
		}
		else {
			return Response.serverError().build();
		}
	}
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response createUser(String userJson){
		IUser user = gson.fromJson(userJson, User.class);
		user = manager.addUser(user);
//		System.out.println(user);
//		return  Response.ok().build();
		if(user!=null){
			return Response.created(uriInfo.getRequestUri().resolve(String.valueOf(user.getId()))).build();
		}
		else {
			return Response.serverError().build();
		}
	}
}
