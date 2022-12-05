package com.example.Hotel.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

public class NotPartnerExceptions  extends Exception{
    public NotPartnerExceptions() {
    }

    public NotPartnerExceptions(String message) {
        super(message);
    }
}
