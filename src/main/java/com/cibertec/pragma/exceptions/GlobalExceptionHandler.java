package com.cibertec.pragma.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(javax.persistence.EntityNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleEntityNotFoundException(javax.persistence.EntityNotFoundException ex) {
        return new ResponseEntity<>(new ResponseDTO("Entidad no encontrada: " + ex.getMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO> handleException(Exception ex) {
        return new ResponseEntity<>(new ResponseDTO("Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
