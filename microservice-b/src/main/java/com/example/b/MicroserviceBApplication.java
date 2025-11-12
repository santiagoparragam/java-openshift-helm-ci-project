package com.example.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;
import java.lang.System;

import java.util.List;

@SpringBootApplication
public class MicroserviceBApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceBApplication.class, args);
    }
}

@RestController
@RequestMapping("/api/b")
class BController {

    private final RecordRepository repository;

    @Autowired
    public BController(RecordRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String getData() {
        System.out.println("IN SERVICE B get:::");
        List<Person> all = repository.findAll();
        return "B: persons=" + all.size();
    }

    @PostMapping("/insert")
    public String insertData(@RequestBody Map<String, String> payload) {
    System.out.println("IN SERVICE B insert:::");
        Person record = new Person();
        record.setName(payload.get("name"));
        repository.save(record);
        return "Record inserted successfully: " + payload.get("name");
    }
}

/*
@SpringBootApplication
public class MicroserviceBApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceBApplication.class, args);
    }
}

@RestController
class BController {
    @Autowired
    private PersonRepository repo;

    @GetMapping("/api/b")
    public String get() {
        System.out.println("IN SERVICE B:::");
        List<Person> all = repo.findAll();
        return "B: persons=" + all.size();
    }
}*/
