package com.centili.test.rest;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.centili.rest.command.DocumentCommand;
import com.centili.rest.dto.DocumentDTO;
import com.centili.test.rest.environment.AbstractControllerTest;

@RunWith(Arquillian.class)
public class DocumentControllerTest extends AbstractControllerTest {
		
	@Test
	public void crudDocumentTest() throws Exception {
		
		WebTarget target = getDeployWebTarget().path("document");
		
		DocumentCommand documentCommand = new DocumentCommand();
		documentCommand.setCode("CODE-1");
		documentCommand.setName("Name-1");

		Entity<DocumentCommand> createDocumentEntity = Entity.entity(documentCommand, MediaType.APPLICATION_JSON_TYPE);
		
		Response createDocumentResponse = target
				.request(MediaType.APPLICATION_JSON_TYPE)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.post(createDocumentEntity);
		
		Assert.assertNotNull(createDocumentResponse);
		
		String documentId = createDocumentResponse.readEntity(String.class);
		Assert.assertNotNull(documentId);
		
		Response loadDocumentResponse = target.path(documentId)
				.request(MediaType.APPLICATION_JSON_TYPE)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get();
		
		DocumentDTO loadedDocument = loadDocumentResponse.readEntity(DocumentDTO.class);
		Assert.assertNotNull(loadedDocument);
		Assert.assertEquals("CODE-1", loadedDocument.getCode());
		Assert.assertEquals("Name-1", loadedDocument.getName());
		
		Response deleteDocumentResponse = target.path(documentId)
				.request(MediaType.APPLICATION_JSON_TYPE)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.delete();
		Assert.assertEquals(204, deleteDocumentResponse.getStatus());
		
		Response loadDocumentAfterDeleteResponse = target.path(documentId)
				.request(MediaType.APPLICATION_JSON_TYPE)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get();	
		Assert.assertEquals(500, loadDocumentAfterDeleteResponse.getStatus());
	}

}