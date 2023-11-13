package org.polytech.covid.exception;

public class CentreNotFoundException extends RuntimeException {
    public CentreNotFoundException(String message) {
        super(message);
    }
}
