package com.movieList.spring.errorHandling;

public class ApiResponse {
  private int statusCode;
  private String message;

  public ApiResponse(int statusCode, String message) {
    this.message = message;
    this.statusCode = statusCode;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}