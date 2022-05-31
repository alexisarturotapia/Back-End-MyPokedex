package com.modyo.mypokedex.exceptions;


public class MyPokedexNotFoundException extends RuntimeException{
    
    public MyPokedexNotFoundException(Integer id){
        super("No hay coincidencia para el id: {" + id + "}");
    }
}
