package com.example.exercice_cinematheque_02.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> notFoundExceptionHandler (NotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entité non trouvée");
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<String> dateTimeParseExceptionHandler (DateTimeParseException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ecrivez la date au format dd/MM/yyyy");
    }
}
