package com.nasser.providerservice.Provider.Service.impl;

import com.nasser.providerservice.SMS.Entity.SMS;
import com.nasser.providerservice.SMS.Service.ISMSProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Qualifier("provider2Service")
public class Provider2ServiceImpl implements ISMSProvider {

    private final RestTemplate restTemplate;
    private final String provider2Url = "http://localhost:8081/provider2/sms";

    public Provider2ServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String sendSMS(SMS sms) {
        return restTemplate.postForObject(provider2Url, sms, String.class);
    }
}