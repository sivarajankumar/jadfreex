package net.jadfreex.test.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.jadfreex.commons.exception.AppException;
import net.jadfreex.test.entity.Usuario;
import net.jadfreex.test.factory.UsuarioFactory;
import net.jadfreex.test.service.UsuarioBO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public String addUsuario(@RequestBody Usuario usuario) {
	try {
	    this.usuarioBO.add(usuario);
	} catch (AppException e) {
	    return e.getMessage();
	}
	return "success";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public String updateUsuario(@RequestParam("id") Long id,
	    @RequestParam("nombre") String nombre,
	    @RequestParam("apPaterno") String apPaterno,
	    @RequestParam("apMaterno") String apMaterno,
	    @RequestParam("username") String username,
	    @RequestParam("password") String password) {
	Usuario u = UsuarioFactory.newInstance(id, nombre, apPaterno,
		apMaterno, username, password);
	try {
	    this.usuarioBO.update(u);
	} catch (AppException e) {
	    return e.getMessage();
	}
	return "sucess";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteUsuario(
	    @RequestParam(value = "id", required = true) Long id) {
	Usuario u = UsuarioFactory.newInstance(id);
	try {
	    this.usuarioBO.delete(u);
	} catch (AppException e) {
	    return e.getMessage();
	}
	return "success";
    }

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

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Usuario> getAll() {
	return this.usuarioBO.getAll();
    }

    @RequestMapping(value = "find/{nombre}", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Usuario> findUsuario(@PathVariable String nombre) {
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("nombre", "'" + nombre + "'");
	System.out.println(nombre);
	return this.usuarioBO.find(map);
    }
}