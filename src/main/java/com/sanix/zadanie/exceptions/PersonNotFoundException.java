package com.sanix.zadanie.exceptions;

public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException(String exMessage, Exception exception){
        super(exMessage, exception);
    }

    public PersonNotFoundException(String exMessage){
        super(exMessage);
    }
}
