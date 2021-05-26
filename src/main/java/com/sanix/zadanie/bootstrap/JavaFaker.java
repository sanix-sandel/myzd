package com.sanix.zadanie.bootstrap;

import com.github.javafaker.Faker;
import com.sanix.zadanie.models.Person;
import com.sanix.zadanie.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JavaFaker extends DataGenerator{

    @Override
    public void generateData(int n, PersonRepository personRepository){
        Faker faker=new Faker();
        for (int i=0; i<n; i++){
            Person person=new Person(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.random().nextInt(1000, 4000),
                    faker.date().birthday()
            );
            try{
                personRepository.save(person);
                logger.info(person+"generated and saved");
            }catch(Exception e){
                logger.info("Invalid entity");
            }

        }
    }
}
