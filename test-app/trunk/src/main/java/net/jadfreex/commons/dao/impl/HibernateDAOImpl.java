package net.jadfreex.commons.dao.impl;

/**
 * DAO generico.
 * 
 * @author José Antonio Díaz Castro
 * @created 10-Dic-2013
 * @version 1.0
 */

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import net.jadfreex.commons.dao.HibernateDAO;
import net.jadfreex.commons.dao.HibernateDAOUtil;
import net.jadfreex.commons.exception.AppException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

public class HibernateDAOImpl<T extends Serializable, PK extends Serializable>
	extends HibernateDAOUtil implements HibernateDAO<T, PK> {

    private Logger log = LoggerFactory.getLogger(getClass());

    private Class type = null;

    @Transactional
    public void add(T obj) {
	Session s = null;
	try {
	    s = this.getSessionFactory().openSession();
	    s.save(obj);
	} catch (HibernateException e) {// Operación
	    throw new AppException("Error de hibernate");
	} catch (IllegalArgumentException e) {// Argumentos no validos
	    throw new AppException("Argumentos no validos");
	} catch (ConstraintViolationException e) {// Restricciones
	    throw new AppException("Se violo una restriccion");
	} finally {
	    if (s != null) {
		s.flush();
		s.close();
	    }
	    System.gc();
	}
    }

    @Transactional
    public void update(T obj) {
	Session s = null;
	try {
	    s = this.getSessionFactory().getCurrentSession();
	    s.update(obj);
	} catch (HibernateException e) {// Operación
	    throw new AppException("Error de hibernate");
	} catch (IllegalArgumentException e) {// Argumentos no validos
	    throw new AppException("Argumentos no validos");
	} catch (ConstraintViolationException e) {// Restricciones
	    throw new AppException("Se violo una restriccion");
	} finally {
	    if (s != null) {
		s.flush();
		s.close();
	    }
	    System.gc();
	}
    }

    @Transactional
    public void delete(T obj) {
	Session s = null;
	try {
	    s = this.getSessionFactory().getCurrentSession();
	    s.delete(obj);
	} catch (HibernateException e) {// Operación
	    throw new AppException("Error de hibernate");
	} catch (IllegalArgumentException e) {// Argumentos no validos
	    throw new AppException("Argumentos no validos");
	} catch (ConstraintViolationException e) {// Restricciones
	    throw new AppException("Se violo una restriccion");
	} finally {
	    if (s != null) {
		s.flush();
		s.close();
	    }
	    System.gc();
	}
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public T get(PK id) {
	Session s = null;
	try {
	    s = this.getSessionFactory().openSession();
	    return (T) s.get(getType(), id);
	} catch (HibernateException e) {// Operación
	    throw new AppException("Error de hibernate");
	} catch (IllegalArgumentException e) {// Argumentos no validos
	    throw new AppException("Argumentos no validos");
	} catch (ConstraintViolationException e) {// Restricciones
	    throw new AppException("Se violo una restriccion");
	} finally {
	    if (s != null) {
		s.flush();
		s.close();
	    }
	    System.gc();
	}
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Collection<T> getAll() {
	Session s = null;
	try {
	    s = this.getSessionFactory().getCurrentSession();
	    Query q = s.createQuery(String.format("FROM %s%", getType()
		    .getSimpleName()));
	    return q.list();
	} catch (HibernateException e) {// Operación
	    throw new AppException("Error de hibernate");
	} catch (IllegalArgumentException e) {// Argumentos no validos
	    throw new AppException("Argumentos no validos");
	} catch (ConstraintViolationException e) {// Restricciones
	    throw new AppException("Se violo una restriccion");
	} finally {
	    if (s != null) {
		s.flush();
		s.close();
	    }
	    System.gc();
	}
    }

    @Transactional(readOnly = true)
    public Collection<T> find(Map<String, Object> parameters) {
	// TODO Auto-generated method stub
	return null;
    }

    @SuppressWarnings("unchecked")
    public Class<T> getType() {
	if (type == null) {
	    @SuppressWarnings("rawtypes")
	    Class clazz = getClass();

	    while (!(clazz.getGenericSuperclass() instanceof ParameterizedType)) {
		clazz = clazz.getSuperclass();
	    }
	    type = (Class<T>) ((ParameterizedType) clazz.getGenericSuperclass())
		    .getActualTypeArguments()[0];
	}
	return type;
    }
}