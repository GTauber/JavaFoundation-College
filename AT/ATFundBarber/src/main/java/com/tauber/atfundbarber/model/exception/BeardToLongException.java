package com.tauber.atfundbarber.model.exception;

import java.io.Serial;

public class BeardToLongException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public BeardToLongException(String message) {
        super(message);
    }
}

