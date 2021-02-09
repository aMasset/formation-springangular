package org.formation.exception;

public class ProduitNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public ProduitNotFoundException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ProduitNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public ProduitNotFoundException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public ProduitNotFoundException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public ProduitNotFoundException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
}