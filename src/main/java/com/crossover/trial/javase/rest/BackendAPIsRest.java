package com.crossover.trial.javase.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crossover.trial.javase.service.BackendAPIsService;

@Path("/restapi")
public class BackendAPIsRest {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(BackendAPIsRest.class);

	private BackendAPIsService service = new BackendAPIsService();

	@GET
	@Path("/get/records")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCurrentRecords(@QueryParam("type") String type) {
		LOGGER.info("Inside getCurrentRecords : type is - {}", type);
		String jsonRecords = service.getCurrentRecords(Integer.valueOf(type));
		return Response.status(Status.OK).entity(jsonRecords).build();
	}

	@GET
	@Path("/get/record")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRecord(@QueryParam("type") String type,
			@QueryParam("code") String code) {
		LOGGER.info("Inside getRecord : type is - {} & code is - {}", type,
				code);
		String jsonRecord = service.getRecord(Integer.valueOf(type),
				Integer.valueOf(code));
		return Response.status(Status.OK).entity(jsonRecord).build();
	}

	@DELETE
	@Path("/delete/record")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRecord(@QueryParam("type") String type,
			@QueryParam("code") String code) {
		LOGGER.info("Inside deleteRecord : type is - {} & code is - {}", type,
				code);
		String jsonRecord = service.deleteRecord(Integer.valueOf(type),
				Integer.valueOf(code));
		return Response.status(Status.OK).entity(jsonRecord).build();
	}

	@POST
	@Path("/save/record/{type}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveRecord(@PathParam("type") String type, String jsonString) {
		LOGGER.info("Inside saveRecord : type is - {}", type);
		LOGGER.info("Inside saveRecord : jsonString is - {}", jsonString);
		String jsonRecord;
		try {
			jsonRecord = service.saveRecord(Integer.valueOf(type), jsonString);
		} catch (Exception e) {
			jsonRecord = e.getMessage();
			LOGGER.error(jsonRecord);
		}
		return Response.status(Status.CREATED).entity(jsonRecord).build();
	}

}