package com.sanix.zadanie.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
public class Person {
    public Person() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min=4, message="name too short")
    private String name;

    @Size(min=4, message="last name too short")
    private String lastName;

    @NotNull(message="salary cannot be null")
    private int salary;

    @NotNull(message="birthdate is required")
    private Date birthdate;

    public Person(String name, String lastName, int salary, Date birthdate) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.birthdate=birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmail() {
        return salary;
    }

    public void setEmail(int email) {
        this.salary = salary;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + salary + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
