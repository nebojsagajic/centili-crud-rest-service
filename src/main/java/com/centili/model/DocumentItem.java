package com.centili.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DOCUMENT_ITEM")
public class DocumentItem implements Serializable {

    private static final long serialVersionUID = 527575964586460497L;

    private Document _document;

    private Long _id;

    private String _name;

    private Long _price;

    @ManyToOne
    @JoinColumn(name = "DOCUMENT_ID", nullable = false)
    public Document getDocument() {
	return _document;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
	return _id;
    }

    @Column(name = "NAME")
    public String getName() {
	return _name;
    }

    @Column(name = "PRICE")
    public Long getPrice() {
	return _price;
    }

    public void setDocument(Document document) {
	_document = document;
    }

    public void setId(Long id) {
	_id = id;
    }

    public void setName(String name) {
	_name = name;
    }

    public void setPrice(Long price) {
	_price = price;
    }

}