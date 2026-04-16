package com.practice.crudjpapract.Exception;
import org.springframework.validation.BindingResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandling {
 /*  @ExceptionHandler (ResponseNotFoundException.class)
   public ResponseEntity <ErrorResponse> handlenotfound(ResponseNotFoundException ex){
       ErrorResponse error = new ErrorResponse("NOT_Found",ex.getMessage());
       return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
   }*/
   @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handlemethodargvalid(MethodArgumentNotValidException mae){
       Map<String ,String> happenderror = new HashMap<>();
       mae.getBindingResult().getFieldErrors().forEach(error ->{happenderror.put(error.getField(), error.getDefaultMessage());});
       ErrorResponse show = new ErrorResponse("BAD_REQUEST",
               "validation error happend",happenderror);
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(show);
   }
   @ExceptionHandler(ResponseNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleresponsenotfound(ResponseNotFoundException rex){
       ErrorResponse response = new ErrorResponse(
               "NOT_FOUND",
               rex.getMessage(),
               null

       );
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
   }
   @ExceptionHandler(BadRequestException.class)
   public ResponseEntity<ErrorResponse> handlebadrequest(BadRequestException bex){
       ErrorResponse badresponse = new ErrorResponse(
               "BAD_REQUEST",
               bex.getMessage(),
               null
       );
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badresponse);
   }
   @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handelallexception(Exception ex){
       ErrorResponse exceptionresponse =new ErrorResponse(
               "Error occurred ",
               ex.getMessage(),
               null
       );
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionresponse);
   }

}
