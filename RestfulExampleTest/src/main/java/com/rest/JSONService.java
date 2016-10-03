package main.java.com.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import main.java.com.jpa.db.DBCall;
import main.java.com.jpa.model.Track;

import javax.naming.NamingException;

@Path("/json/metallica")
public class JSONService {
	private DBCall d = null; 
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Track> getTrackInJSON() throws NamingException {
		d = new DBCall();
		List<Track> track = new ArrayList<Track>();
		track = d.getTrack();
		return track;
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Track track) throws NamingException {
		boolean status = false;
		d = new DBCall();
		status = d.addTrack(track);
		if(status){
			String result = "Track saved : " + track;
			return Response.status(201).entity(result).build();
		}
		else {
			String result = "Error occured processing saving this Track : " + track;
			return Response.status(500).entity(result).build();
		}
			

	}

}