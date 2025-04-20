package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

/* Specialization of @Component for classes that declare @ExceptionHandler, @InitBinder, or @ModelAttribute methods
   to be shared across multiple @Controller classes. By default, @ControllerAdvice apply to every request (that is, all controllers),
   but you can narrow that down to a subset of controllers by using attributes on the annotation:
   @ControllerAdvice(annotations = RestController.class) */
@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleGenericException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(Instant.now().toEpochMilli());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
