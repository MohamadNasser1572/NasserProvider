package com.nasser.provider1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Provider1Application {

    public static void main(String[] args) {
        SpringApplication.run(Provider1Application.class, args);
    }

    @GetMapping("/GETprovider1")
    public String getProvider1(@RequestParam Long phoneNumber,
                               @RequestParam String message) {
        System.out.println("GET working");
        return "GET working with phoneNumber: " + phoneNumber
                + " and message: " + message;
    }
}
