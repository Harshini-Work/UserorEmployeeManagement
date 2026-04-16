package com.practice.crudjpapract.sucess;

public class SucessResponse {
    public String message;
    public Object dto;
    public SucessResponse(String message ,Object dto) {
        this.message=message;
        this.dto=dto;
    }
}
