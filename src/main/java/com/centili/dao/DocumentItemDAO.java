package com.centili.dao;

import java.util.List;

import com.centili.dao.core.GenericDAO;
import com.centili.model.Document;
import com.centili.model.DocumentItem;

public interface DocumentItemDAO extends GenericDAO<DocumentItem> {
    
    DocumentItem findByDocument(Document document, Long itemId);
    
    List<DocumentItem> listByDocument(Document document);

}