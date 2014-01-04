package com.weiminw.web.services;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.weiminw.business.aos.User;
import com.weiminw.business.managers.UserManager;
import com.weiminw.travel.interfaces.IUser;
import com.weiminw.travel.interfaces.IUserManager;

@Path("/users")
public class UserResource {
	IUserManager manager = UserManager.create();
	@Context
	UriInfo uriInfo;
	@POST
	public Response createUser(@FormParam(value = "name") String name,
			@FormParam(value="cellPhone") String cellPhone,
			@FormParam(value="cloudPushKey") String cloudPushKey,
			@FormParam(value = "userType") String userType){
		IUser user = User.builder()
				.setName(name)
				.setCellPhone(cellPhone)
				.setCloudPushKey(cloudPushKey).build();
		user = manager.addUser(user);
		if(user!=null){
			return Response.created(uriInfo.getRequestUri().resolve(String.valueOf(user.getId()))).build();
		}
		else {
			return Response.serverError().build();
		}
	}
}
