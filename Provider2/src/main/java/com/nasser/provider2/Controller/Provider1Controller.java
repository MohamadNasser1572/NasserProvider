package com.nasser.provider2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Provider1Controller {

    @GetMapping("/provider1/sms")
    public String getProvider1(@RequestParam Long phoneNumber,
                               @RequestParam String message) {
        System.out.println("GET working");
        return "GET working with phoneNumber: " + phoneNumber
                + " and message: " + message;
    }
}
