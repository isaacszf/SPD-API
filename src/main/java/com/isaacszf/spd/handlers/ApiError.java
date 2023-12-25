package com.isaacszf.spd.handlers;

import java.time.LocalDateTime;

public class ApiError {
  private final String msg;
  private final int statusCode;
  private final LocalDateTime timestamp;

  public ApiError(String msg, int statusCode) {
    this.msg = msg;
    this.statusCode = statusCode;
    this.timestamp = LocalDateTime.now();
  }

  public String getMsg() {
    return msg;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }
}
