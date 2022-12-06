package com.walerikq.hospital.controller;

import com.walerikq.hospital.PersonDto.ExceptionResponse;
//import jakarta.validation.ConstraintViolationException;
//import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;


@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {



    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleAccessException(ConstraintViolationException ex) {
        log.error(ex.getMessage(),ex);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(400, ex.getMessage()));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAccessException(Exception ex) {
        log.error(ex.getMessage(),ex);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionResponse(500, "Unknown error"));

    }
}