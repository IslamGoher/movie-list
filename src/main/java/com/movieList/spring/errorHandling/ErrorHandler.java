package com.movieList.spring.errorHandling;

import javax.servlet.http.HttpServletResponse;

public class ErrorHandler {
  public static Object handle(Exception err, HttpServletResponse res) {

    // logging error for dev
    System.out.println(err);

    int statusCode = 500;
    String message = "Server error";

    // list exeptions here

    res.setStatus(statusCode);
    return new ErrorResponse(statusCode, message);
  }
}
