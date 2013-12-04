package net.jadfreex.usuario.bo;

import net.jadfreex.commons.AppContext;
import net.jadfreex.usuario.domain.TipoUsuario;
import net.jadfreex.usuario.domain.Usuario;
import net.jadfreex.usuario.factory.TipoUsuarioFactory;
import net.jadfreex.usuario.factory.UsuarioFactory;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioBOTest {

	@Autowired
	private UsuarioBO usuarioBO;

	@Autowired
	private TipoUsuarioBO tipoUsuarioBO;

	@Test
	public void _init() {
	}

	@Test
	public void test() {
		AppContext.load(this, "classpath:app-config.xml");
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

}
