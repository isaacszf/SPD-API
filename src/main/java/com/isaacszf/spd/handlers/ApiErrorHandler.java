package com.isaacszf.spd.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiErrorHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(ApplicationException.class)
  public ResponseEntity<?> handleApplicationException(
    final ApplicationException exception
  ) {
    var response = new ApiError(
      exception.getMessage(),
      exception.getHttpStatus().value()
    );

    return new ResponseEntity<>(response, exception.getHttpStatus());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleUnknownException(
    final Exception exception
  ) {
    var response = new ApiError(
      exception.getMessage(),
      HttpStatus.INTERNAL_SERVER_ERROR.value()
    );

    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
