package com.nasser.providerservice.Service.impl;

import com.nasser.providerservice.Entity.SMS;
import com.nasser.providerservice.Service.ISMSProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SmsServiceImpl implements ISMSProvider {

    private final String provider2URL = "http://localhost:8082/POSTprovider2";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String sendSMS(SMS sms) {
        // Send request
        String response = restTemplate.postForObject(provider2URL, sms, String.class);
        return "Provider 2 Response: " + response;
    }

}
