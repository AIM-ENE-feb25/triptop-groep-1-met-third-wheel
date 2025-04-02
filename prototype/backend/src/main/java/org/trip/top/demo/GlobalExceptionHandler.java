package org.trip.top.demo;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.trip.top.demo.bouwsteen.state.IllegalStateActionException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalStateActionException.class)
    public String handleIllegalStateActionException(IllegalStateActionException e) {
        return e.getMessage();
    }
}
