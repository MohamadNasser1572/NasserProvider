package com.nasser.providerservice.Service;

import com.nasser.providerservice.DTO.SmsRequestDTO;

public interface SmsService {
    String sendSms(SmsRequestDTO smsRequest);
}
