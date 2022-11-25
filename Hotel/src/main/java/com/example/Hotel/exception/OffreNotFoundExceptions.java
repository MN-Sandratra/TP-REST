package com.example.Hotel.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class OffreNotFoundExceptions extends Exception {
    public OffreNotFoundExceptions(String message) {
        super(message);
    }

    public OffreNotFoundExceptions() {
    }
}
