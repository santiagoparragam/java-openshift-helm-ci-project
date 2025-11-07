package com.example.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class MicroserviceAApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceAApplication.class, args);
    }
}
//http://microservice-b:8081
@RestController
class AController {
    private final RestTemplate rest = new RestTemplate();
    @Value("${microservice.b.url:http://microservice-b.santiago-parraga-2-dev.svc.cluster.local:8081}")
    private String bUrl;

    @GetMapping("/api/a")
    public String callB() {
    System.out.println("IN SERVICE A:::");
        ResponseEntity<String> r = rest.getForEntity(bUrl + "/api/b", String.class);
        return "A -> B responded: " + r.getBody();
    }
}
