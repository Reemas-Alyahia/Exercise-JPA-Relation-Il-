package com.example.jpa121.ControllerAdvice;

import com.example.jpa121.ApiResponse.ApiException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException(ApiException e){
        String masssege=e.getMessage();
        return ResponseEntity.status(400).body(masssege);
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e){
        String message =e.getFieldError().getDefaultMessage();

        return ResponseEntity.status(400).body(message);
    }


    @ExceptionHandler(value = DuplicateKeyException.class)
    public ResponseEntity DuplicateKeyException(DuplicateKeyException e){
        String masssege=e.getMessage();
        return ResponseEntity.status(400).body(masssege);
    }

   @ExceptionHandler(value =HttpMessageNotReadableException .class)
public ResponseEntity HttpMessageNotReadableException(HttpMessageNotReadableException e){
    String masssege= e.getMessage();
    return ResponseEntity.status(400).body(masssege);
}
//
////NoResourceFoundException
@ExceptionHandler(value = NoResourceFoundException.class)
public ResponseEntity NoResourceFoundException(NoResourceFoundException e){
    String masssege=e.getMessage();
    return ResponseEntity.status(400).body(masssege);
}
////HttpRequestMethodNotSupportedException
@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
public ResponseEntity HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
    String masssege=e.getMessage();
    return ResponseEntity.status(400).body(masssege);
}

}
