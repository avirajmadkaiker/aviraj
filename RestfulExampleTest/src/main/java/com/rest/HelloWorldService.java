package main.java.com.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import main.java.com.jpa.db.MongoDbCall;

@Path("/hello")
public class HelloWorldService {

	private MongoDbCall mCall = new MongoDbCall();
	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String title) {
		//String output = "Jersey say : " + title;
		String res = mCall.readByImdb(title);
		return Response.status(200).entity(res).build();

	}
	
	@GET
	@Path("/string/{param}")
	public String getMsgString(@PathParam("param") String title) {
		String output = "Jersey say : " + title;
		return output;

	}

}