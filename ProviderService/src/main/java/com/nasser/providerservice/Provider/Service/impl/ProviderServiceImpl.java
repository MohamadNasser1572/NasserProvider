package com.nasser.providerservice.Provider.Service.impl;

import com.nasser.providerservice.RequestPayload.Entity.RequestPayload;
import com.nasser.providerservice.RequestPayload.Repository.RequestPayloadRepository;
import com.nasser.providerservice.Provider.Service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class ProviderServiceImpl implements IProviderService {

    @Autowired
    private RestTemplate restTemplate;

    private RequestPayloadRepository requestPayloadRepository;

    public ProviderServiceImpl(RequestPayloadRepository requestPayloadRepository) {
        this.requestPayloadRepository = requestPayloadRepository;
    }


    @Override
    public String getProvider1(Long phoneNumber, String message) {
        String url = "http://localhost:8081/GETprovider1?phoneNumber=" + phoneNumber + "&message=" + message;
        return restTemplate.getForObject(url, String.class);
    }

    @Override
    public String postProvider2(RequestPayload payload) {
        String url = "http://localhost:8082/provider2/sms";
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

        // Save payload to the database
        requestPayloadRepository.save(payload);
    }


    private String generateRandomCode() {
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
