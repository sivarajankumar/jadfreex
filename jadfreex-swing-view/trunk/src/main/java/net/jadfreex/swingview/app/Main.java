package net.jadfreex.swingview.app;

import net.jadfreex.swingview.commons.AppContext;
import net.jadfreex.usuario.bo.TipoUsuarioBO;
import net.jadfreex.usuario.bo.UsuarioBO;
import net.jadfreex.usuario.domain.TipoUsuario;
import net.jadfreex.usuario.domain.Usuario;
import net.jadfreex.usuario.factory.TipoUsuarioFactory;
import net.jadfreex.usuario.factory.UsuarioFactory;

import org.springframework.beans.factory.annotation.Autowired;

public class Main {

	@Autowired
	private UsuarioBO usuarioBO;

	@Autowired
	private TipoUsuarioBO tipoUsuarioBO;

	Main() {
		AppContext.load(this, "classpath:app-config.xml");
	}

	public void sayHi() {
		TipoUsuario tu = TipoUsuarioFactory.newInstance();
		tu.setNombre("Tipo de prueba");
		tu.setDescripcion("Esta es una prueba");
		this.tipoUsuarioBO.create(tu);

		Usuario u = UsuarioFactory.newInstance();
		u.setNombre("Usuario de prueba");
		u.setTipoUsuario(tu);
		this.usuarioBO.create(u);

		System.out.println("I´m done!");
	}

	public static void main(String args[]) {
		Main m = new Main();
		m.sayHi();
	}

}