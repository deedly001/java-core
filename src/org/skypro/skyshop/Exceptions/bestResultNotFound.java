package org.skypro.skyshop.Exceptions;

public class bestResultNotFound extends Exception {
    public bestResultNotFound() {
    }

    public bestResultNotFound(String message) {
        super(message);
    }

    public bestResultNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public bestResultNotFound(Throwable cause) {
        super(cause);
    }

}