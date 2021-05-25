package com.sanix.zadanie.exceptions;

public class PersonNotValidException extends RuntimeException{

    public PersonNotValidException(String exMessage, Exception exception){
        super(exMessage, exception);
    }

    public PersonNotValidException(String exMessage){
        super(exMessage);
    }
}
