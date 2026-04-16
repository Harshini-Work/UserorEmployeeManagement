package com.practice.crudjpapract.Exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private String status;
    private String message;
    private Map<String,String> errors;
   // private String passworderror;
    public ErrorResponse(String status ,String message,Map<String,String> errors){
        this.status=status;
        this.message = message;
        this.errors=errors;


    }

//    public String getPassworderror() {
//        return passworderror;
//    }
//
//    public void setPassworderror(String passworderror) {
//        this.passworderror = passworderror;
//    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
