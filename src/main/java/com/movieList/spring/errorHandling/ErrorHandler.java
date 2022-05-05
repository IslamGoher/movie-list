package com.movieList.spring.errorHandling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.error.ErrorAttributeOptions.Include;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RestControllerAdvice
public class ErrorHandler implements ErrorController {

  @Autowired
  private ErrorAttributes errorAttributes;

  @ExceptionHandler(ValidationException.class)
  @RequestMapping(path = "/error")
  public Object handleError(HttpServletResponse res, WebRequest webRequest) {

    Map<String, Object> attributes = this.errorAttributes.getErrorAttributes(
      webRequest,
      ErrorAttributeOptions.of(Include.MESSAGE, Include.BINDING_ERRORS)
    );

    int statusCode = 400;
    String message = (String) attributes.get("message");

    // if there's more than one error message
    if(attributes.containsKey("errors")) {

      ArrayList<String> errorMessages = new ArrayList<String>();

      List<FieldError> errors = (List<FieldError>) attributes.get("errors");

      for(FieldError fieldError: errors) {
        errorMessages.add(fieldError.getDefaultMessage());
      }

      HashMap<String, Object> response = new HashMap<String, Object>();

      response.put("statusCode", statusCode);
      response.put("errorMessages", errorMessages);

      res.setStatus(400);
      return response;

    } else {

      if (message.contains(": "))
        message = message.split(": ")[1];
    }


    // list exeptions here
    if (message == "No message available")
      message = "Content not found";

    res.setStatus(statusCode);
    return new ApiResponse(statusCode, message);
  }
}
