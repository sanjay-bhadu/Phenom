package com.example.userDefined.Exception;

public class NotAvailable extends RuntimeException{
    public NotAvailable(String message)
    {
        super(message);
    }
}
