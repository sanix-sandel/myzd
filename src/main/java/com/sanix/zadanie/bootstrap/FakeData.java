package com.sanix.zadanie.bootstrap;

import com.sanix.zadanie.repository.PersonRepository;

public interface FakeData {
    void generateData(int n, PersonRepository personRepository);
}
