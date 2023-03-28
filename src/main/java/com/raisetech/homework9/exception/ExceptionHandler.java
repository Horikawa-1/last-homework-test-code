
package com.raisetech.homework9.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

  //  該当するidが無い時の例外処理
  @org.springframework.web.bind.annotation.ExceptionHandler(value = ResourceNotFoundException.class)
  public ResponseEntity<Map<String, String>> handleNoNameFound(ResourceNotFoundException e,
      HttpServletRequest request) {

    Map<String, String> body = new HashMap<>();
    body.put("timestamp", ZonedDateTime.now().toString());
    body.put("status", String.valueOf(HttpStatus.NOT_FOUND.value()));
    body.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
    body.put("message", e.getMessage());
    body.put("path", request.getRequestURI());

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }

  @org.springframework.web.bind.annotation.ExceptionHandler(ValidationException.class)
  public ResponseEntity<Map<String, String>> handleBatRequest(ValidationException e,
      HttpServletRequest request) {

    Map<String, String> body = Map.of(
        "timestamp", ZonedDateTime.now().toString(),
        "status", String.valueOf(HttpStatus.BAD_REQUEST.value()),
        "error", HttpStatus.BAD_REQUEST.getReasonPhrase(),
        "message", e.getMessage(),
        "path", request.getRequestURI()
    );

    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }
}