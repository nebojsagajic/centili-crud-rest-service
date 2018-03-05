package com.centili.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ws.rs.PathParam;

import com.centili.model.Document;
import com.centili.model.DocumentItem;
import com.centili.rest.command.DocumentItemCommand;
import com.centili.rest.core.AbstractController;
import com.centili.rest.dto.DocumentItemDTO;

@Local
@Stateless
public class DocumentItemControllerBean extends AbstractController implements DocumentItemController {
    
	@Override
    public Long create(@PathParam("documentId") Long documentId, DocumentItemCommand command) throws Exception {
	
	Document document = loadDocument(documentId);
	
	DocumentItem item = new DocumentItem();
	item.setDocument(document);
	item.setName(command.getName());
	item.setPrice(command.getPrice());
	
	return getDocumentItemService().create(item);
    }
    
    @Override
    public List<DocumentItemDTO> list(@PathParam("documentId") Long documentId) throws Exception {
	
	List<DocumentItemDTO> response = new ArrayList<>();
	
	Document document = loadDocument(documentId);

	List<DocumentItem> items = getDocumentItemService().listByDocument(document);
	items.forEach(item -> response.add(createDocumentItemResponse(item)));
	
	return response;
    }

    @Override
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

    
    @Override
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
    
    @Override
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