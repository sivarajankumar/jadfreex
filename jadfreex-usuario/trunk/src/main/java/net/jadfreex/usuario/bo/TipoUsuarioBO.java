package net.jadfreex.usuario.bo;

import java.util.Collection;

import net.jadfreex.usuario.domain.TipoUsuario;

//TODO Documentar
public interface TipoUsuarioBO {

	void create(TipoUsuario obj);

	Collection<TipoUsuario> findAll();

}
