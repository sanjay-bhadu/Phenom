package com.example.userDefined.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<?> objectNotFoundExceptionHandler(ObjectNotFoundException exception){
        Error error=new Error(new Date(),exception.getMessage(),HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ObjectEmpty.class)
    public ResponseEntity<?> objectEmptyHandler(ObjectEmpty exception){
        Error error=new Error(new Date(), exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidInput.class)
    public ResponseEntity<?> invalidInputHandler(InvalidInput exception){
        Error error=new Error(new Date(),exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotAvailable.class)
    public ResponseEntity<?> notAvailableHandler(NotAvailable exception){
        Error error=new Error(new Date(),exception.getMessage(),HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException exception)
    {
        Error error=new Error(new Date(),exception.getMessage(),HttpStatus.NON_AUTHORITATIVE_INFORMATION.toString());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> missingServletRequestParameterHandler(MissingServletRequestParameterException exception)
    {
        Error error=new Error(new Date(),exception.getMessage(),HttpStatus.BAD_GATEWAY.toString());
        return new ResponseEntity<>(error,HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException exception)
    {
        Error error=new Error(new Date(), exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException exception)
    {
        Error error=new Error(new Date(), exception.getMessage(), HttpStatus.BAD_GATEWAY.toString());
        return new ResponseEntity<>(error,HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<?> noHandlerFoundExceptionHandler(NoHandlerFoundException exception)
    {
       Error error=new Error(new Date(),exception.getMessage(),HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<?> numberFormatExceptionHandler(NumberFormatException e)
    {
        Error error=new Error(new Date(),e.getMessage(),HttpStatus.BAD_GATEWAY.toString());
        return new ResponseEntity<>(error,HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<?> httpMediaTypeNotSupportedExceptionHandler(HttpMediaTypeNotSupportedException e)
    {
        Error error=new Error(new Date(),e.getMessage(),HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }


}
