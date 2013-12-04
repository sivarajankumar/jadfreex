package net.jadfreex.usuario.bo.impl;

import java.util.Collection;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import net.jadfreex.commons.exception.AppException;
import net.jadfreex.usuario.bo.UsuarioBO;
import net.jadfreex.usuario.dao.UsuarioDAO;
import net.jadfreex.usuario.domain.Usuario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//TODO Documentar
@Service
public class UsuarioBOImpl implements UsuarioBO {

	private static Logger log = LoggerFactory.getLogger(UsuarioBOImpl.class);

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private Validator validator;

	@Override
	public void create(Usuario obj) {
		if (obj == null) {
			String msg = "El usuario no puede ser nulo.";
			log.debug(msg);
			throw new AppException(msg);
		}
		Set<ConstraintViolation<Usuario>> violations = this.validator
				.validate(obj);
		if (!violations.isEmpty()) {
			throw new AppException("Se presentaron los siguientes errores: "
					+ violations);
		}
		log.info("Iniciando el proceso de creación de usuario");
		this.usuarioDAO.create(obj);
		log.info("Proceso de creación de usuario finalizado");
	}

	@Override
	public Usuario read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Usuario obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Usuario obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}