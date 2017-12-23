package com.centili.dao.core;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

public abstract class AbstractGenericDAO<E extends Serializable> implements GenericDAO<E> {

    private Class<E> _entityClass;

    @PersistenceContext
    private EntityManager _entityManager;
    
    public AbstractGenericDAO(Class<E> entityClass) {
	_entityClass = entityClass;
    }

    @Override
    public Long create(E entity) {
	return (Long) getSession().save(entity);
    }

    @Override
    public void delete(E entity) {
	getSession().delete(entity);
    }
    
    @Override
    public void deleteById(Long id) {
	getSession().delete(findById(id));
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public E findById(Long id) {
	return (E) getSession().get(getEntityClass(), id);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<E> list() {
	return getSession().createCriteria(getEntityClass()).list();
    }

    @Override
    public void update(E entity) {
	getSession().update(entity);
    }

    protected Class<E> getEntityClass() {
	return _entityClass;
    }

    protected EntityManager getEntityManager() {
        return _entityManager;
    }

    protected Session getSession() {
	return getEntityManager().unwrap(Session.class);
    }

}