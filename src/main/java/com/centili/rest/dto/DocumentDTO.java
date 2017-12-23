package com.centili.rest.dto;

public class DocumentDTO {

    private String _code;
    
    private String _date;
    
    private Long _id;
    
    private String _name;

    public String getCode() {
        return _code;
    }

    public String getDate() {
        return _date;
    }

    public Long getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public void setCode(String code) {
        _code = code;
    }

    public void setDate(String date) {
        _date = date;
    }

    public void setId(Long id) {
        _id = id;
    }

    public void setName(String name) {
        _name = name;
    }
    
}