package com.modyo.mypokedex.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

@RestControllerAdvice
public class MyPokedexExceptionHandler{
    
    @ExceptionHandler(value = MyPokedexNotFoundException.class)
    public ResponseEntity<MyPokedexExceptionResponse> handleMyPokedexNotFoundException(MyPokedexNotFoundException ex){
        MyPokedexExceptionResponse errorResponse = new MyPokedexExceptionResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.name());
        errorResponse.setTimestamp(LocalDateTime.now().toString()); 
        errorResponse.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MyPokedexException.class)
    public ResponseEntity<MyPokedexExceptionResponse> handleMyPokedexException(MyPokedexException ex){ 
        MyPokedexExceptionResponse errorResponse = new MyPokedexExceptionResponse();
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
        errorResponse.setTimestamp(LocalDateTime.now().toString()); 
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setCausa(ex.getCause().toString());
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<MyPokedexExceptionResponse> handleRuntimeException(RuntimeException ex){
        MyPokedexExceptionResponse errorResponse = new MyPokedexExceptionResponse();
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
        errorResponse.setTimestamp(LocalDateTime.now().toString()); 
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setCausa(ex.getCause().toString());
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
