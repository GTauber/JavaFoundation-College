package com.tauber.atfundbarber.model.exception;

import java.io.Serial;

public class InvalidBarber extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidBarber(String message) {
        super(message);
    }
}
