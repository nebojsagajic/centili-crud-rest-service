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

    @Override
    public boolean equals(Object object) {
	if (this == object) { return true; }
	if (object == null) { return false; }
	if (getClass() != object.getClass()) { return false; }
	DocumentItem other = (DocumentItem) object;
	if (_document == null) {
	    if (other._document != null) { return false; }
	} else if (!_document.equals(other._document)) { return false; }
	if (_id == null) {
	    if (other._id != null) { return false; }
	} else if (!_id.equals(other._id)) { return false; }
	return true;
    }

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

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((_document == null) ? 0 : _document.hashCode());
	result = prime * result + ((_id == null) ? 0 : _id.hashCode());
	return result;
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