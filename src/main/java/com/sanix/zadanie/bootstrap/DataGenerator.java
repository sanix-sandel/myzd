package com.sanix.zadanie.bootstrap;

import com.sanix.zadanie.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataGenerator {

    protected static Logger logger= LoggerFactory.getLogger(JavaFaker.class);

    public void generateData(int n, PersonRepository personRepository){
        System.out.println("Generating data");
    }
}
