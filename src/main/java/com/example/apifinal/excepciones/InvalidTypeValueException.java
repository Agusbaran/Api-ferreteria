package com.example.apifinal.excepciones;

public class InvalidTypeValueException extends Exception{
    
    public InvalidTypeValueException(String mensaje)
    {
        super(mensaje);
    } 
}
