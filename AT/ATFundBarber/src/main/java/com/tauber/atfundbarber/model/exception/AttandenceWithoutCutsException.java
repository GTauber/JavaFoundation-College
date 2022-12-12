package com.tauber.atfundbarber.model.exception;

import java.io.Serial;

public class AttandenceWithoutCutsException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public AttandenceWithoutCutsException(String message) {
        super(message);
    }
}
