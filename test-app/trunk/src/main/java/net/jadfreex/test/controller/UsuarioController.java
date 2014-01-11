package net.jadfreex.test.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import net.jadfreex.commons.cors.CORSFilter;
import net.jadfreex.commons.exception.AppException;
import net.jadfreex.test.entity.Usuario;
import net.jadfreex.test.factory.UsuarioFactory;
import net.jadfreex.test.service.UsuarioBO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("usr")
public class UsuarioController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UsuarioBO usuarioBO;

    @RequestMapping("add")
    @POST
    @ResponseBody
    public ResponseEntity<String> addUsuario(Usuario u) {
	HttpHeaders header = CORSFilter.addAccessControlAllowOrigin();
	ResponseEntity<String> entity = null;
	try {
	    this.usuarioBO.add(u);
	} catch (AppException e) {
	    entity = new ResponseEntity<String>(e.getMessage(), header,
		    HttpStatus.OK);
	    return entity;
	}
	entity = new ResponseEntity<String>("success", header, HttpStatus.OK);
	return entity;
    }

    @RequestMapping("update")
    @POST
    @ResponseBody
    public String updateUsuario(Usuario u) {
	try {
	    this.usuarioBO.update(u);
	} catch (AppException e) {
	    return e.getMessage();
	}
	return "sucess";
    }

    @RequestMapping("delete")
    @POST
    @ResponseBody
    public String deleteUsuario(@RequestParam("id") Long id) {
	Usuario u = UsuarioFactory.newInstance(id);
	try {
	    this.usuarioBO.delete(u);
	} catch (AppException e) {
	    return e.getMessage();
	}
	return "success";
    }

    @RequestMapping(value = "get")
    @GET
    @ResponseBody
    public ResponseEntity<Usuario> getUsuarioRequest(@RequestParam("id") Long id) {
	HttpHeaders header = CORSFilter.addAccessControlAllowOrigin();
	ResponseEntity<Usuario> entity = new ResponseEntity<Usuario>(
		this.usuarioBO.get(id), header, HttpStatus.OK);
	return entity;
    }

    @RequestMapping("get/{id}")
    @GET
    @ResponseBody
    public ResponseEntity<Usuario> getUsuarioPath(@PathVariable Long id) {
	HttpHeaders header = CORSFilter.addAccessControlAllowOrigin();
	ResponseEntity<Usuario> entity = new ResponseEntity<Usuario>(
		this.usuarioBO.get(id), header, HttpStatus.OK);
	return entity;
    }

    @RequestMapping("list")
    @GET
    @ResponseBody
    public Collection<Usuario> getAll() {
	return this.usuarioBO.getAll();
    }

    @RequestMapping("find/{nombre}")
    @GET
    @ResponseBody
    public Collection<Usuario> findUsuario(@PathVariable String nombre) {
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("nombre", "'" + nombre + "'");
	System.out.println(nombre);
	return this.usuarioBO.find(map);
    }
}