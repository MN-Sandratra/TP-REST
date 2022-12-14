package com.example.Hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotPartnerExceptionAdvice {
    @ExceptionHandler(NotPartnerExceptions.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String NotPartnerExceptionAdviceHandler(NotPartnerExceptions e) {
        return String.format("{\"%s\": \"%s\"}", "error", e.getMessage());
    }
}
