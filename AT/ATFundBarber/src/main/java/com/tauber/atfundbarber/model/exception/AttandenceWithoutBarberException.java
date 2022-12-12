package com.tauber.atfundbarber.model.exception;

import java.io.Serial;

public class AttandenceWithoutBarberException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public AttandenceWithoutBarberException(String message) {
        super(message);
    }
}
