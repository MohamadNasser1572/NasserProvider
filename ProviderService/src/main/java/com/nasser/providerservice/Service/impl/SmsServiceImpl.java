package com.nasser.providerservice.Service.impl;

import com.nasser.providerservice.DTO.SmsRequestDTO;
import com.nasser.providerservice.Service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SmsServiceImpl implements SmsService {

    private final String provider2URL = "http://localhost:8082/POSTprovider2";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String sendSms(SmsRequestDTO smsRequest) {
        // Send request to provider 2
        String response = restTemplate.postForObject(provider2URL, smsRequest, String.class);
        return "Provider 2 Response: " + response;
    }
}
