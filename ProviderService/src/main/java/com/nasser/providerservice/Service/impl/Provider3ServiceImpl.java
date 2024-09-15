package com.nasser.providerservice.Service.impl;

import com.nasser.providerservice.Entity.SMS;
import com.nasser.providerservice.Service.ISMSProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Service
public class Provider3ServiceImpl implements ISMSProvider {
    @Override
    public String sendSMS(SMS sms) {
        final RestTemplate restTemplate = new RestTemplate();
        final String providerUrl = "https://localhost:8082/Provider3";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SMS> request = new HttpEntity<>(sms, headers);
        //PUT request
        restTemplate.put(providerUrl + "/send", request);

        System.out.println("Sending SMS for provider3");

        return "SMS sent for provider3";
    }
}
