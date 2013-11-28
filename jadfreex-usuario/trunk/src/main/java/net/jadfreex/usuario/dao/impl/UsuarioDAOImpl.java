package net.jadfreex.usuario.dao.impl;

import net.jadfreex.commons.dao.impl.GenericDaoImlp;
import net.jadfreex.usuario.bean.Usuario;
import net.jadfreex.usuario.dao.UsuarioDAO;

import org.springframework.stereotype.Repository;

//TODO Documentar
@Repository
public class UsuarioDAOImpl extends GenericDaoImlp<Usuario, Long> implements
		UsuarioDAO {
}
