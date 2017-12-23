package com.centili.dao.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.centili.dao.DocumentDAO;
import com.centili.dao.core.AbstractGenericDAO;
import com.centili.model.Document;

@Stateless
@Local(DocumentDAO.class)
public class DocumentDAOImpl extends AbstractGenericDAO<Document> implements DocumentDAO {

    public DocumentDAOImpl() {
	super(Document.class);
    }

}