package net.jadfreex.swingview.commons;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Inyector de dependencias.
 * 
 * @author José Antonio Díaz Castro
 * @version 1.0
 * @created 04-sep-2013
 */
public class AppContext {

	/**
	 * AppContext
	 */
	private static ConfigurableApplicationContext appContext;

	/**
	 * Configura el appContext.
	 * 
	 * @param config
	 *            archivos de configuración
	 */
	private static void setAppContext(String... config) {
		if (appContext == null) {
			appContext = new ClassPathXmlApplicationContext(config);
		}
		// appContext.registerShutdownHook();
	}

	/**
	 * Inyecta las depencias en el objeto.
	 * 
	 * @param obj
	 *            objeto a inyectar depencias
	 */
	private static void inject(Object obj, String... config) {
		appContext.getBeanFactory().autowireBeanProperties(obj,
				AutowireCapableBeanFactory.AUTOWIRE_NO, false);
	}

	/**
	 * Configura el appContext e inyecta las dependencias al objeto.
	 * 
	 * @param obj
	 *            objecto a injectar dependencias
	 * @param config
	 *            archivos de configuración
	 */
	public static void load(Object obj, String... config) {
		setAppContext(config);
		inject(obj);
	}
}