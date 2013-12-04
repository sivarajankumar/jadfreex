package net.jadfreex.usuario.bo.impl;

import java.util.Collection;

import javax.validation.Validator;

import net.jadfreex.usuario.bo.TipoUsuarioBO;
import net.jadfreex.usuario.dao.TipoUsuarioDAO;
import net.jadfreex.usuario.domain.TipoUsuario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//TODO Documentar
@Service
public class TipoUsuarioBOImpl implements TipoUsuarioBO {

	private static Logger log = LoggerFactory
			.getLogger(TipoUsuarioBOImpl.class);

	@Autowired
	private Validator validator;

	@Autowired
	private TipoUsuarioDAO tipoUsuarioDAO;

	@Override
	public void create(TipoUsuario obj) {
		this.tipoUsuarioDAO.create(obj);
	}

	@Override
	public Collection<TipoUsuario> findAll() {
		return this.tipoUsuarioDAO.findAll();
	}

}
