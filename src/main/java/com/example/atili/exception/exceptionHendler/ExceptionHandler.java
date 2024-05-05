package com.example.atili.exception.exceptionHendler;

import com.example.atili.exception.AppBadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({AppBadRequestException.class})
    public ResponseEntity<String> handleBadRequestException(AppBadRequestException e) {
return ResponseEntity.badRequest().body(e.getMessage());
    }
}
