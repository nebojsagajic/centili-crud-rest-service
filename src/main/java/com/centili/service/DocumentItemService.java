package com.centili.service;

import java.util.List;

import com.centili.model.Document;
import com.centili.model.DocumentItem;
import com.centili.service.core.GenericService;

public interface DocumentItemService extends GenericService<DocumentItem> {

    DocumentItem findByDocument(Document document, Long itemId);
    
    List<DocumentItem> listByDocument(Document document);
    
}