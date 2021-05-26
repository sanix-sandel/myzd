package com.sanix.zadanie.bootstrap;

import com.sanix.zadanie.models.Person;
import com.sanix.zadanie.repository.PersonRepository;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.stereotype.Component;

@Component
public class DFactory extends DataGenerator{



    @Override
    public void generateData(int n, PersonRepository personRepository){
        DataFactory dataFactory=new DataFactory();
        for (int i=0; i<n; i++){
            Person person=new Person(
                    dataFactory.getFirstName(),
                    dataFactory.getLastName(),
                    dataFactory.getNumberUpTo(4000),
                    dataFactory.getDate(1980, 1, 1)
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
