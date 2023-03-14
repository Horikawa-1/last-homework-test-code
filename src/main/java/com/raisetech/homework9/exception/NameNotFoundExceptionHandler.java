
package com.raisetech.homework9.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class NameNotFoundExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = NameNotFoundException.class)
  public ResponseEntity<Map<String, String>> handleNoNameFound(NameNotFoundException e,
      HttpServletRequest request) {

    Map<String, String> body = new HashMap<>();
    body.put("timestamp", ZonedDateTime.now().toString());
    body.put("status", String.valueOf(HttpStatus.NOT_FOUND.value()));
    body.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
    body.put("message", e.getMessage());
    body.put("path", request.getRequestURI());

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }
}