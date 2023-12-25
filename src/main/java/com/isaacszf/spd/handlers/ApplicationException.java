package com.isaacszf.spd.handlers;

import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException {
  private final String message;
  private final HttpStatus httpStatus;

  public ApplicationException(String message, HttpStatus httpStatus) {
    this.message = message;
    this.httpStatus = httpStatus;
  }

  public String getMessage() { return this.message; }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }
}
