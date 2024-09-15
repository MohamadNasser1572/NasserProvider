package com.nasser.provider2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class Provider2Application {

    public static void main(String[] args) {
        SpringApplication.run(Provider2Application.class, args);
    }

    @PostMapping("/provider2/sms")
    public String postProvider2(@RequestBody RequestPayload requestPayload) {
        System.out.println("POST working");
        // Deserialization
        return "POST working with phoneNumber " + requestPayload.getPhoneNumber()
                + ", message " + requestPayload.getMessage()
                + " and language " + requestPayload.getLanguage();
    }

    @GetMapping("/provider1/sms")
    public String getProvider1(@RequestParam Long phoneNumber,
                               @RequestParam String message) {
        System.out.println("GET working");
        return "GET working with phoneNumber: " + phoneNumber
                + " and message: " + message;
    }
}
