package com.centili.rest;

import java.util.ArrayList;
import java.util.Date;
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

import com.centili.model.Document;
import com.centili.rest.command.DocumentCommand;
import com.centili.rest.core.AbstractController;
import com.centili.rest.dto.DocumentDTO;

@Path("document")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DocumentController extends AbstractController {

    @POST
    public Long create(DocumentCommand command) throws Exception {

	Document document = new Document();
	document.setCode(command.getCode());
	document.setDate(new Date());
	document.setName(command.getName());

	return getDocumentService().create(document);
    }

    @GET
    public List<DocumentDTO> list() throws Exception {

	List<DocumentDTO> response = new ArrayList<>();

	List<Document> documents = getDocumentService().list();
	documents.forEach(document -> response.add(createDocumentResponse(document)));

	return response;
    }

    @GET
    @Path("{documentId}")
    public DocumentDTO load(@PathParam("documentId") Long documentId) throws Exception {
	
	Document document = loadDocument(documentId);
	
	return createDocumentResponse(document);
    }

    @DELETE
    @Path("{documentId}")
    public void remove(@PathParam("documentId") Long documentId) throws Exception {

	getDocumentService().deleteById(documentId);
    }

    @PUT
    @Path("{documentId}")
    public void update(@PathParam("documentId") Long documentId, DocumentCommand command) throws Exception {

	Document document = loadDocument(documentId);
	
	document.setCode(command.getCode());
	document.setName(command.getName());

	getDocumentService().update(document);
    }

    private DocumentDTO createDocumentResponse(Document document) {

	DocumentDTO response = new DocumentDTO();

	response.setCode(document.getCode());
	response.setDate(DATE_FORMAT.format(document.getDate()));
	response.setId(document.getId());
	response.setName(document.getName());

	return response;
    }

}