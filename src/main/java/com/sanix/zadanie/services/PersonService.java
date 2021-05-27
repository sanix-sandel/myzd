package com.sanix.zadanie.services;

import com.sanix.zadanie.models.Person;
import org.springframework.data.domain.Page;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface PersonService {

    void addUsers(int n);

    Person findByName(String name);

    List<Person>getUsers();
    Person findById(Long id);

    void deleteOne(String name);
    void deleteAll();
    void deleteByRange(int limit);
    Page<Person> findPaginated(int pageNo, int pageSize);

}
