package com.example.exercice_gestionrh_03.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> notFoundExceptionHandler (NotFoundException ex){
        return new ResponseEntity<>("not found entity from advice", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<String> dateTimeParseExceptionHandler (DateTimeParseException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ecrivez la date au format dd/MM/yyyy");
    }

    @ExceptionHandler(AbsenceException.class)
    public ResponseEntity<String> dateTimeParseExceptionHandler (AbsenceException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Entrez soit une date d'absence, soit une date de départ en Vacance et de retour");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Map<String,String>>> handleBindErrors(MethodArgumentNotValidException ex) {
        List<Map<String, String>> errorList = ex.getFieldErrors().stream().map(fieldError -> {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            return errorMap;
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
    }
}
