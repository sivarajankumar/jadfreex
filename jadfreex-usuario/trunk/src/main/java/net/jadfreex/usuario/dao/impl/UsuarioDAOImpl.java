package net.jadfreex.usuario.dao.impl;

import net.jadfreex.commons.dao.impl.GenericDaoImlp;
import net.jadfreex.usuario.dao.UsuarioDAO;
import net.jadfreex.usuario.domain.Usuario;

import org.springframework.stereotype.Repository;

//TODO Documentar
@Repository
public class UsuarioDAOImpl extends GenericDaoImlp<Usuario, Long> implements
		UsuarioDAO {
}
