package com.centili.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.centili.dao.DocumentItemDAO;
import com.centili.dao.core.GenericDAO;
import com.centili.model.Document;
import com.centili.model.DocumentItem;
import com.centili.service.DocumentItemService;
import com.centili.service.core.AbstractGenericService;

@Stateless
public class DocumentItemServiceImpl extends AbstractGenericService<DocumentItem> implements DocumentItemService {
    
    @Inject
    private DocumentItemDAO _documentItemDAO;
    
    @Override
    public DocumentItem findByDocument(Document document, Long itemId) {
	return getDocumentItemDAO().findByDocument(document, itemId);
    }

    @Override
    public List<DocumentItem> listByDocument(Document document) {
	return getDocumentItemDAO().listByDocument(document);
    }

    private DocumentItemDAO getDocumentItemDAO() {
        return _documentItemDAO;
    }

    @Override
    protected GenericDAO<DocumentItem> getEntityDAO() {
	return _documentItemDAO;
    }

}