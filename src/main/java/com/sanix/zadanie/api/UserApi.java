package com.sanix.zadanie.api;

import com.sanix.zadanie.models.Person;
import com.sanix.zadanie.services.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @GetMapping
    @RequestMapping("/generate/{n}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addUsers(@PathVariable("n") int n){
        personService.addUsers(n);
        return new ResponseEntity("Users added successfully", HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/getuser/{name}")
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

    @DeleteMapping
    @RequestMapping("/deleteone/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteUser(@PathVariable("name")String name){
        personService.deleteOne(name);
        return new ResponseEntity("User deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping
    @RequestMapping("/delete/all/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteAllUsers(){
        personService.deleteAll();
        return new ResponseEntity("Users deleted", HttpStatus.OK);
    }

    @DeleteMapping
    @RequestMapping("/delete/{n}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteByRange(@PathVariable("n")int n){

        personService.deleteByRange(n);
        return new ResponseEntity("User deleted successfully", HttpStatus.OK);
    }
}
