package net.jadfreex.map.factory;

import net.jadfreex.map.entity.Estado;

public class EstadoFactory {

	public static Estado newInstance() {
		return new Estado();
	}

	public static Estado newInstance(Long id) {
		Estado e = new Estado();
		e.setId(id);
		return e;
	}

}