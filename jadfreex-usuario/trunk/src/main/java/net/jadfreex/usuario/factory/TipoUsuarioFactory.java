package net.jadfreex.usuario.factory;

import net.jadfreex.usuario.bean.TipoUsuario;

//TODO Documentar
public class TipoUsuarioFactory {

	public static TipoUsuario newInstance() {
		return new TipoUsuario();
	}

	public static TipoUsuario newInstance(Long id) {
		TipoUsuario u = newInstance();
		u.setId(id);
		return u;
	}

}
