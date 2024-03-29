package net.jadfreex.test.service.impl;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import net.jadfreex.commons.exception.AppException;
import net.jadfreex.test.entity.Usuario;
import net.jadfreex.test.repository.UsuarioDAO;
import net.jadfreex.test.service.UsuarioBO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioBOImpl implements UsuarioBO {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private Validator validator;

    public void add(Usuario obj) {
	if (obj == null) {
	    throw new AppException("El usuario no puede ser nulo");
	}
	Set<ConstraintViolation<Usuario>> violations = this.validator
		.validate(obj);
	if (!violations.isEmpty()) {
	    String msg = "";
	    for (ConstraintViolation<Usuario> v : violations) {
		msg += v.getPropertyPath() + ": " + v.getMessage();
	    }
	    throw new AppException(msg);
	}
	this.usuarioDAO.add(obj);
    }

    public void update(Usuario obj) {
	if (obj == null) {
	    throw new AppException("El usuario no puede ser nulo");
	}
	Set<ConstraintViolation<Usuario>> violations = this.validator
		.validate(obj);
	if (!violations.isEmpty()) {
	    String msg = "";
	    for (ConstraintViolation<Usuario> v : violations) {
		msg += v.getPropertyPath() + ": " + v.getMessage();
	    }
	    throw new AppException(msg);
	}
	this.usuarioDAO.update(obj);
    }

    public void delete(Usuario obj) {
	if (obj == null) {
	    throw new AppException("El usuario no puede ser nulo");
	}
	Set<ConstraintViolation<Usuario>> violations = this.validator
		.validateProperty(obj, "id");
	if (!violations.isEmpty()) {
	    String msg = "";
	    for (ConstraintViolation<Usuario> v : violations) {
		msg += v.getPropertyPath() + ": " + v.getMessage();
	    }
	    throw new AppException(msg);
	}
	this.usuarioDAO.delete(obj);
    }

    public Usuario get(Long id) {
	if (id == null) {
	    throw new AppException("El id del usuario no puede ser nulo");
	}
	return this.usuarioDAO.get(id);
    }

    public Collection<Usuario> getAll() {
	return this.usuarioDAO.getAll();
    }

    public Collection<Usuario> find(Map<String, Object> parameters) {
	return this.usuarioDAO.find(parameters);
    }
}