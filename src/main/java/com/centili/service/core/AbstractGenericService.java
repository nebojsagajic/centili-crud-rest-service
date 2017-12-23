package com.centili.service.core;

import java.io.Serializable;
import java.util.List;

import com.centili.dao.core.GenericDAO;

public abstract class AbstractGenericService<E extends Serializable> implements GenericService<E> {

    @Override
    public Long create(E entity) {
	return getEntityDAO().create(entity);
    }

    @Override
    public void delete(E entity) {
	getEntityDAO().delete(entity);
    }

    @Override
    public void deleteById(Long id) {
	getEntityDAO().deleteById(id);
    }

    @Override
    public E findById(Long id) {
	return getEntityDAO().findById(id);
    }

    @Override
    public List<E> list() {
	return getEntityDAO().list();
    }

    @Override
    public void update(E entity) {
	getEntityDAO().update(entity);
    }

    protected abstract GenericDAO<E> getEntityDAO();

}