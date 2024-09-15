package com.nasser.providerservice.Service.impl;

import com.nasser.providerservice.Entity.SMS;
import com.nasser.providerservice.Service.ISMSProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Service
public class Provider2ServiceImpl implements ISMSProvider {
    @Override
    public String sendSMS(SMS sms) {
        final RestTemplate restTemplate = new RestTemplate();
        final String providerUrl = "http://localhost:8082/Provider2";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SMS> request = new HttpEntity<>(sms, headers);

        //POST request
        ResponseEntity<String> response = restTemplate.postForEntity(providerUrl + "/send", request, String.class);

        System.out.println("Sending SMS for provider2");

        return response.getBody();
    }
}
