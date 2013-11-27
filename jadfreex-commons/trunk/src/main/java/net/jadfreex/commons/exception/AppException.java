package net.jadfreex.commons.exception;

//TODO Documentar
public class AppException extends RuntimeException {

	private static final long serialVersionUID = 3836080583925097459L;

	public AppException() {
		super("Default Exception, excepcion lanzada sin descripcion.");
	}

	public AppException(Throwable ex) {
		super("Default Exception, excepcion lanzada sin descripcion.", ex);
	}

	public AppException(String message) {
		super(message);
	}

	public AppException(String message, Throwable ex) {
		super(message, ex);
	}
}
