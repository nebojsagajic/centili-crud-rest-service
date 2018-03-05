package com.centili.test.rest;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.centili.dao.DocumentDAO;
import com.centili.model.Document;
import com.centili.test.rest.environment.AbstractDAOTest;

@RunWith(Arquillian.class)
public class DocumentDAOTest extends AbstractDAOTest {

	@Inject
	private DocumentDAO documentDAO;
	
	@Test
	public void crudTest() throws Exception {
		
		Assert.assertNotNull(documentDAO);
		
		Document document = new Document();
		document.setCode("CODE-123");
		document.setName("NAME-123");
		
		Long documentId = documentDAO.create(document);
		Assert.assertNotNull(documentId);
	
		Document loadedDocument = documentDAO.findById(documentId);
		Assert.assertNotNull(loadedDocument);
		Assert.assertEquals("CODE-123", loadedDocument.getCode());
		Assert.assertEquals("NAME-123", loadedDocument.getName());
	}
	
}