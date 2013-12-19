package net.jadfreex.commons.exception;

/**
 * Excepción de la aplicación
 * 
 * @author José Antonio Díaz Castro
 * @created 10-Dic-2013
 * @version 1.0
 */

public class AppException extends RuntimeException {

    private static final long serialVersionUID = 2999258407159339481L;

    public AppException(String msg) {
	super(msg);
    }

    public AppException(Throwable ex) {
	super(ex);
    }

    public AppException(String msg, Throwable ex) {
	super(msg, ex);
    }

}