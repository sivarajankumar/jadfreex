package net.jadfreex.usuario.bo;

import java.util.Collection;

import net.jadfreex.usuario.bean.Usuario;

//TODO Documentar
public interface UsuarioBO {

	void create(Usuario obj);

	Usuario read(Long id);

	void update(Usuario obj);

	void delete(Usuario obj);

	Collection<Usuario> findAll();

}