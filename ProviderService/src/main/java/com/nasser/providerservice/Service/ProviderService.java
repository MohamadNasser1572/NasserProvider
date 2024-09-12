package com.nasser.providerservice.Service;

import com.nasser.providerservice.Model.RequestPayload;

public interface ProviderService {

    String getProvider1(Long phoneNumber, String message);

    String postProvider2(RequestPayload payload);

    void sendScheduledSms();

    String generateRandomCode();
}
