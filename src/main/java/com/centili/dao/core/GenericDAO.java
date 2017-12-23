package com.centili.dao.core;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<E extends Serializable> {

    Long create(E entity);
    
    void delete(E entity);
    
    void deleteById(Long id);
    
    E findById(Long id);
    
    List<E> list();
    
    void update(E entity);
    
}