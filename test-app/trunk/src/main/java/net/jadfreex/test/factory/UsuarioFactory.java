package net.jadfreex.test.factory;

import net.jadfreex.test.entity.Usuario;

public class UsuarioFactory {

    public static Usuario newInstance() {
	return new Usuario();
    }

    public static Usuario newInstance(Long id) {
	Usuario u = newInstance();
	u.setId(id);
	return u;
    }

    public static Usuario newInstance(String nombre, String apPaterno,
	    String apMaterno, String username, String password) {
	Usuario u = new Usuario();
	u.setNombre(nombre);
	u.setApPaterno(apPaterno);
	u.setApMaterno(apMaterno);
	u.setUsername(username);
	u.setPassword(password);
	return u;
    }

    public static Usuario newInstance(Long id, String nombre, String apPaterno,
	    String apMaterno, String username, String password) {
	Usuario u = new Usuario();
	u.setId(id);
	u.setNombre(nombre);
	u.setApPaterno(apPaterno);
	u.setApMaterno(apMaterno);
	u.setUsername(username);
	u.setPassword(password);
	return u;
    }

}
