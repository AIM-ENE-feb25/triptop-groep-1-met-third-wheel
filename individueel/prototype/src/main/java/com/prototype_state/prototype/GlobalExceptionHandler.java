package com.prototype_state.prototype;

import com.prototype_state.prototype.domain.state.IllegalStateActionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalStateActionException.class)
    public String handleIllegalStateActionException(IllegalStateActionException e) {
        return e.getMessage();
    }
}
