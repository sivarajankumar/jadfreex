package net.jadfreex.test.repository.impl;

import net.jadfreex.commons.dao.impl.HibernateDAOImpl;
import net.jadfreex.test.entity.Usuario;
import net.jadfreex.test.repository.UsuarioDAO;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAOImpl extends HibernateDAOImpl<Usuario, Long> implements
		UsuarioDAO {
}
