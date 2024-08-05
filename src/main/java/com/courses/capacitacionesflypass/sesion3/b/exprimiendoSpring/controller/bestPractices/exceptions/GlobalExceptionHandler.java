package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.controller.bestPractices.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        // Manejo global de excepciones
        return ResponseEntity.status(500).body(e.getMessage());
    }
}
