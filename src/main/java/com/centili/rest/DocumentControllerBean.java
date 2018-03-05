package com.centili.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ws.rs.PathParam;

import com.centili.model.Document;
import com.centili.rest.command.DocumentCommand;
import com.centili.rest.core.AbstractController;
import com.centili.rest.dto.DocumentDTO;

@Local
@Stateless
public class DocumentControllerBean extends AbstractController implements DocumentController {
	
	@Override
	public Long create(DocumentCommand command) throws Exception {

		Document document = new Document();
		document.setCode(command.getCode());
		document.setDate(new Date());
		document.setName(command.getName());

		return getDocumentService().create(document);
	}

	@Override
	public List<DocumentDTO> list() throws Exception {

		List<DocumentDTO> response = new ArrayList<>();

		List<Document> documents = getDocumentService().list();
		documents.forEach(document -> response.add(createDocumentResponse(document)));

		return response;
	}

	@Override
	public DocumentDTO load(@PathParam("documentId") Long documentId) throws Exception {

		Document document = loadDocument(documentId);

		return createDocumentResponse(document);
	}
	
	@Override
	public void remove(@PathParam("documentId") Long documentId) throws Exception {

		getDocumentService().deleteById(documentId);
	}

	@Override
	public void update(@PathParam("documentId") Long documentId, DocumentCommand command) throws Exception {

		Document document = loadDocument(documentId);

		document.setCode(command.getCode());
		document.setName(command.getName());

		getDocumentService().update(document);
	}

	private DocumentDTO createDocumentResponse(Document document) {

		DocumentDTO response = new DocumentDTO();

		response.setCode(document.getCode());
		response.setDate(DATE_FORMAT.format(document.getDate()));
		response.setId(document.getId());
		response.setName(document.getName());

		return response;
	}

}