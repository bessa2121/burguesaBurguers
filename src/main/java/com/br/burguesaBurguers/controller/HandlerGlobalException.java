package com.br.burguesaBurguers.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class HandlerGlobalException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException ex) {
        return buildResponse(
                HttpStatus.NOT_FOUND,
                "Recurso não encontrado",
                ex.getMessage()
        );
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidation(ValidationException ex) {
        return buildResponse(
                HttpStatus.BAD_REQUEST,
                "Erro de validação",
                ex.getMessage()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntime(RuntimeException ex) {
        return buildResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Erro interno",
                ex.getMessage()
        );
    }

    private ResponseEntity<ErrorResponse> buildResponse(
            HttpStatus status, String error, String message) {

        ErrorResponse response = new ErrorResponse(
                status.value(),
                error,
                message,
                LocalDateTime.now()
        );

        return ResponseEntity.status(status).body(response);
    }
}
