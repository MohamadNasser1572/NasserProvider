package com.nasser.providerservice;

import com.fasterxml.jackson.core.util.RequestPayload;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ProviderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderServiceApplication.class, args);
    }

    //RestTemplate to send http requests
    //used bean to create an instance of rest template and manage it (DI)
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/GETprovider1")
    public String getProvider1(@RequestParam Long phoneNumber, @RequestParam String message) {//request param to access provided URL in the method
        System.out.println("GET working");
        //add the url then the response since it is GET
        String url = "http://localhost:8081/GETprovider1?phoneNumber=" + phoneNumber + "&message=" + message;
        String response = restTemplate().getForObject(url, String.class);//getForObject sends request and receive response with type String
        return response;
    }

    @PostMapping("/POSTprovider2")
    public String postProvider2(@RequestBody RequestPayload requestPayload) {//use request payload to change the json as object( POJO).
        System.out.println("POST working");
        String url = "http://localhost:8082/POSTprovider2?";
        String response = restTemplate().postForObject(url, requestPayload, String.class);//sends the URL that contains the data(request payload) to provider2 and returns a String.
        return response;
    }
}
