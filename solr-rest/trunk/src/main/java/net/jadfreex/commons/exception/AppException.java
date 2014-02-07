package net.jadfreex.commons.exception;

public class AppException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AppException() {
	super();
    }

    public AppException(String msg) {
	super(msg);
    }

    public AppException(String msg, Throwable ex) {
	super(msg, ex);
    }

}
