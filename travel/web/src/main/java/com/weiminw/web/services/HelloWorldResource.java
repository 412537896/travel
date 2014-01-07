package com.weiminw.web.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
 
@Path("helloworld")
public class HelloWorldResource {
    public static final String CLICHED_MESSAGE = "Hello World!";
 
@GET
@Produces("text/plain")
    public Response getHello() {
        return Response.accepted().build();
    }
}