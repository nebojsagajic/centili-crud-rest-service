package com.centili.dao.impl;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import com.centili.dao.DocumentItemDAO;
import com.centili.dao.core.AbstractGenericDAO;
import com.centili.model.Document;
import com.centili.model.DocumentItem;

@Stateless
@Local(DocumentItemDAO.class)
public class DocumentItemDAOImpl extends AbstractGenericDAO<DocumentItem> implements DocumentItemDAO {

    public DocumentItemDAOImpl() {
	super(DocumentItem.class);
    }

    @Override
    public DocumentItem findByDocument(Document document, Long itemId) {

	Criteria criteria = getSession()
		.createCriteria(getEntityClass())
		.add(Restrictions.idEq(itemId))
		.add(Restrictions.eq("document", document))
		.setFetchMode("document", FetchMode.SELECT);

	return (DocumentItem) criteria.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<DocumentItem> listByDocument(Document document) {
	
	Criteria criteria = getSession()
		.createCriteria(getEntityClass())
		.add(Restrictions.eq("document", document))
		.setFetchMode("document", FetchMode.SELECT);

	return criteria.list();
    }

}