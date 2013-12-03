package net.jadfreex.commons.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import javax.validation.ConstraintViolationException;

import net.jadfreex.commons.dao.GenericDao;
import net.jadfreex.commons.exception.AppException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

//TODO Documentar
public abstract class GenericDaoImlp<T extends Serializable, PK extends Serializable>
		implements GenericDao<T, PK> {

	protected static final Logger log = LoggerFactory
			.getLogger(GenericDaoImlp.class);

	@Autowired
	protected SessionFactory sessionFactory;

	private Class<T> type = null;

	@Transactional
	@Override
	public void create(T obj) {
		try {
			log.debug("Iniciando la creacion de un objeto");
			this.sessionFactory.getCurrentSession().save(obj);
			log.debug("El objeto se creo correctamente.");
		} catch (HibernateException ex) {
			log.error("Error en la creacion del objeto", ex);
			throw new AppException("Error de acceso a datos", ex);
		} catch (ConstraintViolationException ex) {
			log.error("Error en la creacion del objeto", ex);
			throw new AppException(
					"Se esta violando una restriccion en la base de datos.", ex);
		} catch (IllegalArgumentException ex) {
			log.error("Error en la creacion del objeto", ex);
			throw new AppException(
					"Existen argumentos no validos al intentar guardar el objeto.",
					ex);
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public T read(PK id) {
		try {
			return (T) this.sessionFactory.getCurrentSession().get(getType(),
					id);
		} catch (IllegalArgumentException ex) {
			String message = "Error al recuperar el objeto desde la base de datos.";
			log.error(message, ex);
			throw new AppException(message, ex);
		}
	}

	@Transactional
	@Override
	public void update(T obj) {
		try {
			this.sessionFactory.getCurrentSession().update(obj);
		} catch (HibernateException ex) {
			String message = "Error al intentar modificar el objeto en a base de datos.";
			log.error(message, ex);
			throw new AppException(message, ex);
		} catch (ConstraintViolationException ex) {
			log.error("Error en la creacion del objeto", ex);
			throw new AppException(
					"Se esta violando una restriccion en la base de datos.", ex);
		} catch (IllegalArgumentException ex) {
			throw new AppException(
					"Existen argumentos no validos al interntar actualizar le objeto",
					ex);
		}
	}

	@Transactional
	@Override
	public void delete(T obj) {
		try {
			this.sessionFactory.getCurrentSession().delete(obj);
		} catch (HibernateException ex) {
			log.error("Error en la creacion del objeto", ex);
			throw new AppException("Error de acceso a datos", ex);
		} catch (ConstraintViolationException ex) {
			log.error("Error en la creacion del objeto", ex);
			throw new AppException(
					"Se esta violando una restriccion en la base de datos.", ex);
		} catch (IllegalArgumentException ex) {
			log.error("Error en la creacion del objeto", ex);
			throw new AppException(
					"Existen argumentos no validos al intentar guardar el objeto.",
					ex);
		}
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public Collection<T> findAll() {
		Session session = null;
		List<T> list = null;

		try {
			log.debug("Recuperando una sesion de la base de datos.");
			session = sessionFactory.openSession();

			Query query = session.createQuery(String.format("from %s obj",
					getType().getSimpleName()));
			list = query.list();
		} catch (HibernateException ex) {
			String mensaje = String.format("Error al recuperar todos los "
					+ "objetos de tipo {%s} en la base de datos", getType()
					.getSimpleName());
			log.error(mensaje, ex);
			throw new AppException(mensaje, ex);
		} finally {
			session.close();
		}
		return list;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class<T> getType() {
		if (type == null) {
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
