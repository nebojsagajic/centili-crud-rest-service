package com.centili.rest.core;

import java.text.Format;
import java.text.SimpleDateFormat;

import javax.inject.Inject;

import com.centili.model.Document;
import com.centili.service.DocumentItemService;
import com.centili.service.DocumentService;

public abstract class AbstractController {

    protected static Format DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    
    @Inject
    private DocumentItemService _documentItemService;
    
    @Inject
    private DocumentService _documentService;
    
    protected DocumentItemService getDocumentItemService() {
        return _documentItemService;
    }
    
    protected DocumentService getDocumentService() {
        return _documentService;
    }
    
    protected Document loadDocument(Long documentId) throws Exception {
	
	Document document = getDocumentService().findById(documentId);
	
	if (document == null) {
	    throw new Exception(
		    "Unable to find document with ID: "
		    .concat(String.valueOf(documentId)));
	}
	
	return document;
    }
    
}