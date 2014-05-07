package net.jadfreex.map.bll.impl;

import java.util.Collection;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import net.jadfreex.commons.exception.AppException;
import net.jadfreex.map.bll.EstadoBll;
import net.jadfreex.map.dao.EstadoDao;
import net.jadfreex.map.entity.Estado;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoBllImpl implements EstadoBll {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private EstadoDao usuarioDAO;

	@Autowired
	private Validator validator;

	public void add(Estado obj) {
		if (obj == null) {
			throw new AppException("El estado no puede ser nulo");
		}
		Set<ConstraintViolation<Estado>> violations = this.validator
				.validate(obj);
		if (!violations.isEmpty()) {
			String msg = "";
			for (ConstraintViolation<Estado> v : violations) {
				msg += v.getPropertyPath() + ": " + v.getMessage();
			}
			throw new AppException(msg);
		}
		this.usuarioDAO.add(obj);
	}

	// public void update(Estado obj) {
	// if (obj == null) {
	// throw new AppException("El estado no puede ser nulo");
	// }
	// Set<ConstraintViolation<Estado>> violations = this.validator
	// .validate(obj);
	// if (!violations.isEmpty()) {
	// String msg = "";
	// for (ConstraintViolation<Estado> v : violations) {
	// msg += v.getPropertyPath() + ": " + v.getMessage();
	// }
	// throw new AppException(msg);
	// }
	// this.usuarioDAO.update(obj);
	// }
	//
	// public void delete(Estado obj) {
	// if (obj == null) {
	// throw new AppException("El estado no puede ser nulo");
	// }
	// Set<ConstraintViolation<Estado>> violations = this.validator
	// .validateProperty(obj, "id");
	// if (!violations.isEmpty()) {
	// String msg = "";
	// for (ConstraintViolation<Estado> v : violations) {
	// msg += v.getPropertyPath() + ": " + v.getMessage();
	// }
	// throw new AppException(msg);
	// }
	// this.usuarioDAO.delete(obj);
	// }

	public Estado get(Long id) {
		if (id == null) {
			throw new AppException("El id del estado no puede ser nulo");
		}
		return this.usuarioDAO.get(id);
	}

	public Collection<Estado> getAll() {
		return this.usuarioDAO.getAll();
	}
}