package com.centili.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DOCUMENT")
public class Document implements Serializable {

    private static final long serialVersionUID = 512953505876968542L;

    private String _code;

    private Date _date;

    private Long _id;

    private List<DocumentItem> _items;

    private String _name;

    @Column(name = "CODE")
    public String getCode() {
	return _code;
    }

    @Column(name = "DATE")
    public Date getDate() {
	return _date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
	return _id;
    }

    @OneToMany(mappedBy = "document", fetch = FetchType.LAZY, orphanRemoval = true)
    public List<DocumentItem> getItems() {
	return _items;
    }

    @Column(name = "NAME")
    public String getName() {
	return _name;
    }

    public void setCode(String code) {
	_code = code;
    }

    public void setDate(Date date) {
	_date = date;
    }

    public void setId(Long id) {
	_id = id;
    }

    public void setItems(List<DocumentItem> items) {
	_items = items;
    }

    public void setName(String name) {
	_name = name;
    }

}