package net.jadfreex.swingview.usuario;

import net.jadfreex.swingview.commons.AppContext;

public class Main {
	
	Main() {
		AppContext.load(this, "classpath:app-config.xml");
		System.out.println("Ya estuvo?");
	}
	
	public static void main(String args[]) {
		Main m = new Main();
	}

}
