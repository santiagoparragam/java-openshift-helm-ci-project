package com.example.b;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

@Entity
public class Person {
    @Id @GeneratedValue
    private Long id;
    private String name;

    public Person() {}
    public Person(String name) { this.name = name; }
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

interface PersonRepository extends JpaRepository<Person, Long> { }
