package com.sanix.zadanie.api;

import com.github.javafaker.Faker;
import com.sanix.zadanie.models.Person;
import com.sanix.zadanie.services.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/")
public class UserApi {

    private PersonService personService;

    public UserApi(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("{n}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUsers(@PathVariable("n") int n){
        personService.addUsers(n);
    }

    @GetMapping("/getuser/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Person getUser(@PathVariable("name") String name){
        return personService.findByName(name);
    }


    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getAll(){
        return personService.getUsers();
    }

    @GetMapping("/{pageNo}/{pageSize}")
    @ResponseStatus(HttpStatus.OK)
    public Page<Person> getUsers(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize){
        return personService.findPaginated(pageNo, pageSize);
    }

    @DeleteMapping("{Id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("Id")Long Id){
        personService.deleteOne(Id);
    }

    @DeleteMapping("delete/all/")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllUsers(){
        personService.deleteAll();
    }

    @DeleteMapping("/delete/{n}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteByRange(@PathVariable("id")int n){
        personService.deleteByRange(n);
    }
}
