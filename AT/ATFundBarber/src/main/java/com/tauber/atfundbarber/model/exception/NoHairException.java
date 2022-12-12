package com.tauber.atfundbarber.model.exception;

import java.io.Serial;

public class NoHairException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public NoHairException(String message) {
        super(message);
    }
}

