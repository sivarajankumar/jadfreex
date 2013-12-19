package net.jadfreex.test.controller;

import net.jadfreex.commons.exception.AppException;
import net.jadfreex.test.entity.Usuario;
import net.jadfreex.test.factory.UsuarioFactory;
import net.jadfreex.test.service.UsuarioBO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("usr")
public class UsuarioController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UsuarioBO usuarioBO;

    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public Usuario getUsuarioJSONParam(
	    @RequestParam(value = "id", required = true) Long id) {
	return this.usuarioBO.get(id);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Usuario getUsuarioJSONPath(@PathVariable Long id) {
	return this.usuarioBO.get(id);
    }

    @RequestMapping(value = "post", method = RequestMethod.POST)
    @ResponseBody
    public String pruebaPOST(
	    @RequestParam(value = "test", required = true) String prueba) {
	System.out.println(prueba);
	return prueba;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public String addUsuario(@RequestParam("nombre") String nombre,
	    @RequestParam("apPaterno") String apPaterno,
	    @RequestParam("apMaterno") String apMaterno,
	    @RequestParam("username") String username,
	    @RequestParam("password") String password) {
	Usuario u = UsuarioFactory.newInstance(nombre, apPaterno, apMaterno,
		username, password);
	try {
	    this.usuarioBO.add(u);
	} catch (AppException e) {
	    return e.getMessage();
	}
	return "Usuario insertado exitosamente";
    }

}