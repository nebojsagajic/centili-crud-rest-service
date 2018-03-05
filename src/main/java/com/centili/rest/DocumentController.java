package com.centili.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.centili.rest.command.DocumentCommand;
import com.centili.rest.dto.DocumentDTO;

@Path("document")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface DocumentController {
	
	@POST
	Long create(DocumentCommand command) throws Exception;
	
	@GET
	List<DocumentDTO> list() throws Exception;
	
	@GET
	@Path("{documentId}")
	DocumentDTO load(@PathParam("documentId") Long documentId) throws Exception;
	
	@DELETE
	@Path("{documentId}")
	void remove(@PathParam("documentId") Long documentId) throws Exception;
	
	@PUT
	@Path("{documentId}")
	void update(@PathParam("documentId") Long documentId, DocumentCommand command) throws Exception;

}