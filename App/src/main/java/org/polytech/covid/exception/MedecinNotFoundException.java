

package org.polytech.covid.exception;

public class MedecinNotFoundException extends RuntimeException {
    public MedecinNotFoundException(String message) {
        super(message);
    }
}