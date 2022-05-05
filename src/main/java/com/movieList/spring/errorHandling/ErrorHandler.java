package com.movieList.spring.errorHandling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.error.ErrorAttributeOptions.Include;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;
import java.util.Map;

@RestController
@RestControllerAdvice
public class ErrorHandler implements ErrorController {

  @Autowired
  private ErrorAttributes errorAttributes;

  @ExceptionHandler(ValidationException.class)
  @RequestMapping(path = "/error")
  public ApiResponse handleError(HttpServletResponse res, WebRequest webRequest) {

    Map<String, Object> attributes = this.errorAttributes.getErrorAttributes(
      webRequest,
      ErrorAttributeOptions.of(Include.MESSAGE, Include.BINDING_ERRORS)
    );

    int statusCode = 400;
    String message = (String) attributes.get("message");

    if (message.contains(": "))
      message = message.split(": ")[1];

    // list exeptions here
    if (message == "No message available")
      message = "Content not found";

    res.setStatus(statusCode);
    return new ApiResponse(statusCode, message);
  }
}
