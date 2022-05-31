package com.modyo.mypokedex.exceptions;


public class MyPokedexException extends RuntimeException{
    
    public MyPokedexException(Throwable ex){
        super("Ups! algo salió muy mal", ex);
    }
}
