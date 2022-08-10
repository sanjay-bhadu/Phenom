package com.example.userDefined.Exception;
public class InvalidInput extends RuntimeException{
    public InvalidInput(String message){
        super(message);
    }
}
