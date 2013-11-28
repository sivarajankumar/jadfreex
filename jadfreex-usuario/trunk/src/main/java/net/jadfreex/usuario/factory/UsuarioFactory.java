package net.jadfreex.usuario.factory;

import net.jadfreex.usuario.bean.Usuario;

//TODO Documentar
public class UsuarioFactory {

	public static Usuario newInstance() {
		return new Usuario();
	}

	public static Usuario newInstance(Long id) {
		Usuario u = newInstance();
		u.setId(id);
		return u;
	}

}
