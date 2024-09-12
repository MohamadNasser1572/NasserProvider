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

    @PostMapping("/POSTprovider2")
    public String postProvider2(@RequestBody RequestPayload requestPayload) {
        System.out.println("POST working");
        //deserialization
        return "POST working with phoneNumber " + requestPayload.getPhoneNumber()
                + ", message " + requestPayload.getMessage()
                + " and language " + requestPayload.getLanguage();
    }
}
