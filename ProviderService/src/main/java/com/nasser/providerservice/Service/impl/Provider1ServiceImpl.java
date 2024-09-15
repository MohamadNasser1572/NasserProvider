package com.nasser.providerservice.Service.impl;

import com.nasser.providerservice.Entity.SMS;
import com.nasser.providerservice.Service.ISMSProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Qualifier("provider1Service")
public class Provider1ServiceImpl implements ISMSProvider {
    //here we are putting the provider URL
    private final RestTemplate restTemplate;
    private final String provider1Url = "http://localhost:8081/GETprovider1/sms";

    public Provider1ServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String sendSMS(SMS sms) {
        String url = provider1Url + "?phoneNumber=" + sms.getPhoneNumber() + "&message=" + sms.getMessage();
        return restTemplate.getForObject(url, String.class);
    }
}
