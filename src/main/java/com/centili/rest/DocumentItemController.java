package com.centili.rest;

import java.util.ArrayList;
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
import com.centili.model.DocumentItem;
import com.centili.rest.command.DocumentItemCommand;
import com.centili.rest.core.AbstractController;
import com.centili.rest.dto.DocumentItemDTO;

@Path("document/{documentId}/item")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DocumentItemController extends AbstractController {
    
    @POST
    public Long create(@PathParam("documentId") Long documentId, DocumentItemCommand command) throws Exception {
	
	Document document = loadDocument(documentId);
	
	DocumentItem item = new DocumentItem();
	item.setDocument(document);
	item.setName(command.getName());
	item.setPrice(command.getPrice());
	
	return getDocumentItemService().create(item);
    }
    
    @GET
    public List<DocumentItemDTO> list(@PathParam("documentId") Long documentId) throws Exception {
	
	List<DocumentItemDTO> response = new ArrayList<>();
	
	Document document = loadDocument(documentId);

	List<DocumentItem> items = getDocumentItemService().listByDocument(document);
	items.forEach(item -> response.add(createDocumentItemResponse(item)));
	
	return response;
    }

    @GET
    @Path("{itemId}")
    public DocumentItemDTO load(@PathParam("documentId") Long documentId, @PathParam("itemId") Long itemId) throws Exception {
	
	Document document = loadDocument(documentId);
	
	DocumentItem item = getDocumentItemService().findByDocument(document, itemId);
	if (item == null) {
	    throw new Exception(String.format(
		    "Unable to find document item. Item ID: %s; Document ID: %s.",
		    String.valueOf(documentId),
		    String.valueOf(itemId)));
	}
	
	return createDocumentItemResponse(item);
    }

    
    @DELETE
    @Path("{itemId}")
    public void remove(@PathParam("documentId") Long documentId, @PathParam("itemId") Long itemId) throws Exception {
	
	Document document = loadDocument(documentId);
	
	DocumentItem item = getDocumentItemService().findByDocument(document, itemId);
	if (item == null) {
	    throw new Exception(String.format(
		    "Unable to find document item. Item ID: %s; Document ID: %s.",
		    String.valueOf(itemId),
		    String.valueOf(documentId)));
	}
	
	getDocumentItemService().delete(item);
    }
    
    @PUT
    @Path("{itemId}")
    public void update(@PathParam("documentId") Long documentId, @PathParam("itemId") Long itemId, DocumentItemCommand command) throws Exception {
	
	Document document = loadDocument(documentId);
	
	DocumentItem item = getDocumentItemService().findByDocument(document, itemId);
	if (item == null) {
	    throw new Exception(String.format(
		    "Unable to find document item. Item ID: %s; Document ID: %s.",
		    String.valueOf(documentId),
		    String.valueOf(itemId)));
	}

	item.setName(command.getName());
	item.setPrice(command.getPrice());
	
	getDocumentItemService().update(item);
    }
    
    private DocumentItemDTO createDocumentItemResponse(DocumentItem item) {
	
	DocumentItemDTO itemDTO = new DocumentItemDTO();
	
	itemDTO.setId(item.getId());
	itemDTO.setName(item.getName());
	itemDTO.setPrice(item.getPrice());
	
	return itemDTO;
    }
    
}