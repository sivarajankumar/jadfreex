package net.jadfreex.commons.dao;

/**
 * Interfaz para DAO generico.
 * 
 * @author José Antonio Díaz Castro
 * @created 10-Dic-2013
 * @version 1.0
 */

import java.util.Collection;

public interface HibernateDAO<T, PK> {

	void add(T obj);

	// void update(T obj);
	//
	// void delete(T obj);

	T get(PK id);

	Collection<T> getAll();

}