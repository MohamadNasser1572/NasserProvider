package com.nasser.providerservice.Service;

import com.nasser.providerservice.Entity.RequestPayload;

public interface IProviderService {

    String getProvider1(Long phoneNumber, String message);

    String postProvider2(RequestPayload payload);

    void sendScheduledSms();
}
