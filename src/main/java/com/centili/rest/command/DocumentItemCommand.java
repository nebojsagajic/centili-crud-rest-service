package com.centili.rest.command;

public class DocumentItemCommand {

    private String _name;
    
    private Long _price;

    public String getName() {
        return _name;
    }

    public Long getPrice() {
        return _price;
    }

    public void setName(String name) {
        _name = name;
    }

    public void setPrice(Long price) {
        _price = price;
    }
    
}