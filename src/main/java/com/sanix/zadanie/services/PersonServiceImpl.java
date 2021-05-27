package com.sanix.zadanie.services;

import com.github.javafaker.Faker;
import com.sanix.zadanie.bootstrap.DFactory;
import com.sanix.zadanie.bootstrap.DataGenerator;
import com.sanix.zadanie.bootstrap.FakeData;
import com.sanix.zadanie.bootstrap.JavaFaker;
import com.sanix.zadanie.exceptions.PersonNotFoundException;
import com.sanix.zadanie.models.Person;
import com.sanix.zadanie.repository.PersonRepository;
import org.fluttercode.datafactory.impl.DataFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

    private static Logger logger= LoggerFactory.getLogger(JavaFaker.class);

    private final PersonRepository personRepository;
    private final JavaFaker faker;
    private final DFactory dataFactory;

    public PersonServiceImpl(PersonRepository personRepository, JavaFaker faker, DFactory dataFactory) {
        this.personRepository = personRepository;
        this.faker=faker;
        this.dataFactory=dataFactory;
    }


    @Override
    public void addUsers(int n) {

        FakeData fk=new JavaFaker();
        fk.generateData(n, personRepository);
    }

    @Override
    public Person findByName(String name) {
        Optional<Person> personOptional=personRepository.findByName(name);
        if (! personOptional.isPresent()){
            throw new PersonNotFoundException("user not found");
        }
        Person person=personOptional.get();
        return person;
    }

    @Override
    public Person findById(Long id){
        Optional<Person> personOptional=personRepository.findById(id);
        if(!personOptional.isPresent()){
            throw new PersonNotFoundException("Person not found");
        }
        return personOptional.get();
    }

    @Override
    public List<Person> getUsers() {
        return personRepository.findAll();
    }

    @Override
    public Page<Person> findPaginated(int pageNo, int pageSize) {
        Sort sort =  Sort.by("name").ascending();


        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.personRepository.findAll(pageable);
    }

    @Override
    public void deleteOne(String name) {
        Optional<Person> personOptional=personRepository.findByName(name);

        if (!personOptional.isPresent()){
            throw new PersonNotFoundException("user not found");
        }
        Person person=personOptional.get();
        personRepository.delete(person);
        logger.info(person+" deleted");

    }

    @Override
    public void deleteAll() {
        personRepository.deleteAll();
        logger.info("All users deleted");
    }

    @Override
    public void deleteByRange(int limit) {
        Page<Person>page=personRepository.findAll(
                PageRequest.of(0, limit)
        );
        personRepository.deleteAll(page);
        logger.info(limit+" users deleted");

    }


}
