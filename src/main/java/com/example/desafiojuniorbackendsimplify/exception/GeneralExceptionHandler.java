package com.example.desafiojuniorbackendsimplify.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    private ResponseEntity<?> handleConflict(NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não registrada!");
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<?> handleConflict(DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Campo(s) inválido(s)!");
    }

    @ExceptionHandler(TarefaJaExistenteException.class)
    private ResponseEntity<?> handleConflict(TarefaJaExistenteException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
