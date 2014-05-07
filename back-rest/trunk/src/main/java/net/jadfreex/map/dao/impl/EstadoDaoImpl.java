package net.jadfreex.map.dao.impl;

import net.jadfreex.commons.dao.impl.HibernateDAOImpl;
import net.jadfreex.map.dao.EstadoDao;
import net.jadfreex.map.entity.Estado;

import org.springframework.stereotype.Repository;

@Repository
public class EstadoDaoImpl extends HibernateDAOImpl<Estado, Long> implements
		EstadoDao {
}
