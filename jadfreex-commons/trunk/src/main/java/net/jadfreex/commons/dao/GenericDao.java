package net.jadfreex.commons.dao;

import java.util.Collection;

//TODO Documentar
public interface GenericDao<T, PK> {

	void create(T obj);
	T read(PK id);
	void update(T obj);
	void delete(T obj);
	Collection<T> findAll();
	
}