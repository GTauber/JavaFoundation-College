package com.tauber.atfundbarber.model.exception;

import java.io.Serial;

public class ToMuchWiresException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public ToMuchWiresException(String message) {
        super(message);
    }
}
