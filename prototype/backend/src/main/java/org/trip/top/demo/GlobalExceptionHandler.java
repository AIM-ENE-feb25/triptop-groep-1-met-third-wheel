package org.trip.top.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.trip.top.demo.bouwsteen.state.IllegalStateActionException;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(IllegalStateActionException.class)
  public ResponseEntity<String> handleIllegalStateActionException(IllegalStateActionException e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
  }
}
