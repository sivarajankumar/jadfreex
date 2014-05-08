package net.jadfreex.map.controller;

import java.util.Collection;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import net.jadfreex.commons.exception.AppException;
import net.jadfreex.map.bll.EstadoBll;
import net.jadfreex.map.entity.Estado;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("map")
public class EstadoController {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private EstadoBll usuarioBO;

	@RequestMapping("add")
	@POST
	@ResponseBody
	public String addUsuario(Estado u) {
		String entity = null;
		try {
			this.usuarioBO.add(u);
		} catch (AppException e) {
			entity = e.getMessage();
			return entity;
		}
		entity = "success";
		return entity;
	}

	//
	// @RequestMapping("update")
	// @POST
	// @ResponseBody
	// public ResponseEntity<String> updateUsuario(Estado u) {
	// HttpHeaders headers = CORSFilter.addAccessControlAllowOrigin();
	// ResponseEntity<String> entity = null;
	// try {
	// this.usuarioBO.update(u);
	// } catch (AppException e) {
	// entity = new ResponseEntity<String>(e.getMessage(), headers,
	// HttpStatus.OK);
	// return entity;
	// }
	// entity = new ResponseEntity<String>("success", headers, HttpStatus.OK);
	// return entity;
	// }
	//
	// @RequestMapping("delete")
	// @POST
	// @ResponseBody
	// public ResponseEntity<String> deleteUsuario(@RequestParam("id") Long id)
	// {
	// HttpHeaders headers = CORSFilter.addAccessControlAllowOrigin();
	// ResponseEntity<String> entity = null;
	// Estado u = EstadoFactory.newInstance();
	// try {
	// this.usuarioBO.delete(u);
	// } catch (AppException e) {
	// entity = new ResponseEntity<>(e.getMessage(), headers,
	// HttpStatus.OK);
	// return entity;
	// }
	// entity = new ResponseEntity<String>("success", headers, HttpStatus.OK);
	// return entity;
	// }

	@RequestMapping(value = "get")
	@GET
	@ResponseBody
	public Estado getUsuarioRequest(@RequestParam("id") Long id) {
		Estado entity = this.usuarioBO.get(id);
		return entity;
	}

	@RequestMapping("get/{id}")
	@GET
	@ResponseBody
	public int[][] getUsuarioPath(@PathVariable Long id) {
		int n[][] = new int[5][];
		Random r = new Random();
		for (int i = 0; i < n.length; i++) {
			n[i] = new int[] { r.nextInt(100), r.nextInt(100) };
		}
		return n;
	}

	@RequestMapping("list")
	@GET
	@ResponseBody
	public Collection<Estado> getAll() {
		String color[] = { "red", "orange", "yellow", "aqua" };
		Random r = new Random();
		int i;
		Collection<Estado> col = this.usuarioBO.getAll();
		for (Estado e : col) {
			i = r.nextInt(color.length);
			e.setColor(color[i]);
		}
		return col;
	}
}