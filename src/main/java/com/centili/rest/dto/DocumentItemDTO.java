package com.centili.rest.dto;

public class DocumentItemDTO {

    private Long _id;

    private String _name;

    private Long _price;

    public Long getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public Long getPrice() {
        return _price;
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