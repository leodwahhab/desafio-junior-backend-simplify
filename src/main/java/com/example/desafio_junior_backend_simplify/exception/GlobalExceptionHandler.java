package com.example.desafio_junior_backend_simplify.exception;

import jakarta.persistence.EntityExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handle(Throwable e) {
        var message = "Algo deu errado.";
        logger.error(message, e);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<String> handleEmailCadastrado(EntityExistsException e) {
        return new ResponseEntity<>("email já cadastrado", HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> invalidUser(InvalidParameterException e) {
        return new ResponseEntity<>("dados inválidos! verifique e tente novamente.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handle(NoSuchElementException e) {
        return new ResponseEntity<>("email inválido", HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public ResponseEntity<String> handleHttpMethodNotAllowed(HttpRequestMethodNotSupportedException e) {
//        return new ResponseEntity<>("HTTP method not allowed.", HttpStatus.METHOD_NOT_ALLOWED);
//    }
}
