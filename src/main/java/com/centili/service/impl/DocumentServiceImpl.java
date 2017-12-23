package com.centili.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.centili.dao.DocumentDAO;
import com.centili.dao.core.GenericDAO;
import com.centili.model.Document;
import com.centili.service.DocumentService;
import com.centili.service.core.AbstractGenericService;

@Stateless
public class DocumentServiceImpl extends AbstractGenericService<Document> implements DocumentService {

    @Inject
    private DocumentDAO _documentDAO;
    
    @Override
    protected GenericDAO<Document> getEntityDAO() {
	return _documentDAO;
    }

}