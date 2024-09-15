package com.nasser.providerservice.Service.impl;

import com.nasser.providerservice.Entity.SMS;
import com.nasser.providerservice.Service.ISMSProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Service
public class Provider1ServiceImpl implements ISMSProvider {

    @Override
    public String sendSMS(SMS sms) {
        final RestTemplate restTemplate = new RestTemplate();
        final String providerUrl = "https://localhost:8082/provider1";

        ResponseEntity<String> response = restTemplate.getForEntity(providerUrl + "/send?phoneNumber=" + sms.getPhoneNumber() + "&message=" + sms.getMessage(), String.class);

        System.out.println("Sending SMS for provider1");

        return response.getBody();
    }
}
