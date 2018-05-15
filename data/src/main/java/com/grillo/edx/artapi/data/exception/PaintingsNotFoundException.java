package com.grillo.edx.artapi.data.exception;

public class PaintingsNotFoundException extends Exception {

    public PaintingsNotFoundException() {
        super();
    }

    public PaintingsNotFoundException(final String message) {
        super(message);
    }

    public PaintingsNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public PaintingsNotFoundException(final Throwable cause) {
        super(cause);
    }

}
