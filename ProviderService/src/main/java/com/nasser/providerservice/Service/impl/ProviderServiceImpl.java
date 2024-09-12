package com.nasser.providerservice.Service.impl;

import com.nasser.providerservice.Model.RequestPayload;
import com.nasser.providerservice.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getProvider1(Long phoneNumber, String message) {
        String url = "http://localhost:8081/GETprovider1?phoneNumber=" + phoneNumber + "&message=" + message;
        return restTemplate.getForObject(url, String.class);
    }

    @Override
    public String postProvider2(RequestPayload payload) {
        String url = "http://localhost:8082/POSTprovider2";
        return restTemplate.postForObject(url, payload, String.class);
    }

    @Override
    public void sendScheduledSms() {
        String message = "Your current code is " + generateRandomCode();

        RequestPayload payload = new RequestPayload();
        payload.setPhoneNumber(1234567890L);
        payload.setMessage(message);
        payload.setLanguage("ENGLISH");

        String response = postProvider2(payload);
        System.out.println("Scheduled sms sent: " + response);
    }

    @Override
    public String generateRandomCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder randomCode = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            randomCode.append(characters.charAt(index));
        }

        return randomCode.toString();
    }
}
