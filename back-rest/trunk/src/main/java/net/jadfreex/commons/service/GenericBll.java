package net.jadfreex.commons.service;

/**
 * Interfaz para BO.
 * 
 * @author José Antonio Díaz Castro
 * @created 10-Dic-2013
 * @version 1.0
 */

import java.util.Collection;

public interface GenericBll<T, PK> {

	void add(T obj);

	// void update(T obj);
	//
	// void delete(T obj);

	T get(PK id);

	Collection<T> getAll();
}