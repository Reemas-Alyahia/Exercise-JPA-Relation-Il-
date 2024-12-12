package com.example.jpa121.ApiResponse;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
