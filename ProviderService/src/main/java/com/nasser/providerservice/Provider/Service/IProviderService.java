package com.nasser.providerservice.Provider.Service;

import com.nasser.providerservice.RequestPayload.Entity.RequestPayload;

public interface IProviderService {

    String getProvider1(Long phoneNumber, String message);

    String postProvider2(RequestPayload payload);

    void sendScheduledSms();
}
