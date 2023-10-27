package com.kopz.library.exception;


import org.springframework.http.HttpStatus;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;




import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerException {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleNotValidException(MethodArgumentNotValidException exception){
        FieldError fieldError = exception.getBindingResult().getFieldErrors().get(0);

        return "Campo " + fieldError.getField() + " message: " + fieldError.getDefaultMessage();

    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(NoSuchElementException.class)
    public String handleNoElement(NoSuchElementException exception){
        return exception.getMessage();
    }



}
