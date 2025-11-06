package com.example.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        List<Person> all = repo.findAll();
        return "B: persons=" + all.size();
    }
}
