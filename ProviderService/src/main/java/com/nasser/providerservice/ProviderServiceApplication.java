package com.nasser.providerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@SpringBootApplication
@RestController
@EnableScheduling
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
        //add the url then the response since it is GET
        String url = "http://localhost:8081/GETprovider1?phoneNumber=" + phoneNumber + "&message=" + message;
        String response = restTemplate().getForObject(url, String.class);//getForObject sends request and receive response with type String
        return response;
    }

    @PostMapping("/POSTprovider2")
    public String postProvider2(@RequestBody RequestPayload requestPayload) {//use request payload to change the json as object( POJO).
        String url = "http://localhost:8082/POSTprovider2";
        String response = restTemplate().postForObject(url, requestPayload, String.class);//sends the URL that contains the data(request payload) to provider2 and returns a String.
        return response;
    }


    @Scheduled(fixedRate = 30000)//milliseconds
    public void sendScheduledSms() {
        String message = "Your current code is " + generateRandomCode();

        RequestPayload payload = new RequestPayload();
        //serialization
        payload.setPhoneNumber(1234567890L);
        payload.setMessage(message);
        payload.setLanguage("ENGLISH");

        String url = "http://localhost:8082/POSTprovider2";
        String response = restTemplate().postForObject(url, payload, String.class);
        System.out.println("Scheduled sms sent: " + response);
    }


    public String generateRandomCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        String randomCode = "";

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());//generate random index from the characters string
            randomCode += characters.charAt(index);
        }

        return randomCode;
    }

}
